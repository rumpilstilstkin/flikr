package flikr.rumpilstilstkin.ru.myapplication.view.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.Comparator;

import flikr.rumpilstilstkin.ru.myapplication.R;

public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        String[] strings = {"e", "r", "asdfsdf", "asd", "asdas"};
        Integer[] integer = {6, 7, 8, 9, 5};
        Arrays.sort(strings, new LengthComp());

        Arrays.sort(
                strings,
                (firstString, secondString) ->
                        Integer.compare(firstString.length(), secondString.length())
        );

        Comparator<String> lengthComp =
                (firstString, secondString) ->
                        Integer.compare(firstString.length(), secondString.length());

        Arrays.sort(strings, lengthComp);
    }

    class LengthComp implements Comparator<String> {

        public int compare(String firstString, String secondString) {
            return Integer.compare(firstString.length(), secondString.length());
        }
    }
}
