package flikr.rumpilstilstkin.ru.myapplication.view.profile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import flikr.rumpilstilstkin.ru.myapplication.R;
import flikr.rumpilstilstkin.ru.myapplication.view.GlideApp;


public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_button)
    Button button;

    @BindView(R.id.profile_image)
    ImageView image;

    @OnClick(R.id.profile_button)
    public void onClick(){
        Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GlideApp
                .with(this)
                .load("http://img-e.photosight.ru/a83/6804322_xlarge.jpg")
                .into(image);
    }
}
