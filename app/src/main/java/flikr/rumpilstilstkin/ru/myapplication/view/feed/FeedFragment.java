package flikr.rumpilstilstkin.ru.myapplication.view.feed;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import flikr.rumpilstilstkin.ru.myapplication.R;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.subscribers.DisposableSubscriber;


public class FeedFragment extends Fragment {

    private String str;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Observable
        Disposable disposable = Observable.just(8).subscribeWith(new DisposableObserver<Integer>() {

            @Override
            public void onNext(@NonNull Integer integer) {
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
        disposable.dispose();

        Observable.just(9, 7, 8).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                d.dispose();
            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //Flowable

        Flowable.just(8).subscribe(new Subscriber<Integer>() {

            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onComplete() {
            }
        });

        Disposable disposable2 = Flowable.just(8).subscribeWith(new DisposableSubscriber<Integer>() {

            @Override
            public void onNext(Integer integer) {
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onComplete() {
            }
        });
        disposable2.dispose();

        //Single
        Disposable disposable3 = Single.just(9L).subscribeWith(new DisposableSingleObserver<Long>() {

            @Override
            public void onSuccess(@NonNull Long aLong) {
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        });

        //Completable
        Disposable disposable4 = Completable.fromAction(
                () -> {
                    int v = 6 + 10;
                }
        ).subscribeWith(new DisposableCompletableObserver() {

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        });

        //Maybe
        Disposable disposable5 = Maybe.just(1).subscribeWith(new DisposableMaybeObserver<Integer>() {

            @Override
            public void onSuccess(Integer t) {
                System.out.println(t);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        });
    }

    private void myFlowable() {
        Flowable<Integer> flowable = Flowable.create(emitter -> {
            for (int i = 1; i <= 20; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.d("Dto", "interrupted " + e);
                    return;
                }
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }
}
