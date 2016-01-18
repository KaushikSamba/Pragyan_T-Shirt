package org.pragyan.pragyantshirtapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CouponFragment extends Fragment {
    OnClickListener listener;
    View view;

    public CouponFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof CouponFragment.OnClickListener)
            listener = (OnClickListener) activity;
    }

    public interface OnClickListener {
        public void CouponToGender();
        public void OpenConfirmPage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coupon, container, false);
        handleButtonClicks();
        return view;
    }

    private void handleButtonClicks() {
        Button button500 = (Button) view.findViewById(R.id.Rs550);
        Button button700 = (Button) view.findViewById(R.id.Rs700);
        button500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call confirmation screen
                Utilities.amount = 550;
                Utilities.gender = Utilities.shirtSize = null;
                listener.OpenConfirmPage();
            }
        });
        button700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call detail selection fragment
                Utilities.amount = 700;
                listener.CouponToGender();
            }
        });
    }
}
