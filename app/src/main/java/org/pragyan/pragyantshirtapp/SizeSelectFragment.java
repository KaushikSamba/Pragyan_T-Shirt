package org.pragyan.pragyantshirtapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SizeSelectFragment extends Fragment {
    View view;
    OnClickListener listener;

    public SizeSelectFragment() {
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof SizeSelectFragment.OnClickListener)
            listener = (OnClickListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_size_select, container, false);
        handleButtonClicks();
        return view;
    }

    private void handleButtonClicks()
    {
        Button s = (Button) view.findViewById(R.id.SizeS);
        Button m = (Button) view.findViewById(R.id.SizeM);
        Button l = (Button) view.findViewById(R.id.SizeL);
        Button xl = (Button) view.findViewById(R.id.SizeXL);
        Button xxl = (Button) view.findViewById(R.id.SizeXXL);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.shirtSize="S";
                listener.OpenConfirmPage();
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.shirtSize = "M";
                listener.OpenConfirmPage();
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.shirtSize = "L";
                listener.OpenConfirmPage();
            }
        });

        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.shirtSize = "XL";
                listener.OpenConfirmPage();
            }
        });

        xxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.shirtSize = "XXL";
                listener.OpenConfirmPage();
            }
        });

    }
    public interface OnClickListener
    {
        public void OpenConfirmPage();
    }
}
