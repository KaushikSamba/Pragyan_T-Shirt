package org.pragyan.pragyantshirtapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GenderSelectFragment extends Fragment {
    View view;
    OnClickListener listener;

    public GenderSelectFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gender_select, container, false);
        handleButtonClicks();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof GenderSelectFragment.OnClickListener)
            listener = (OnClickListener) activity;
    }
    public interface OnClickListener
    {
        public void GenderToShirtSize();
    }

    private void handleButtonClicks() {
        Button maleButton = (Button) view.findViewById(R.id.male);
        Button femaleButton = (Button) view.findViewById(R.id.female);
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.gender = "male";
                listener.GenderToShirtSize();
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.gender="female";
                listener.GenderToShirtSize();
            }
        });
    }
}
