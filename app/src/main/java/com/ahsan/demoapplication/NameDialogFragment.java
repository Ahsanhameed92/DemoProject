package com.ahsan.demoapplication;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vengile on 4/12/2016.
 */
public class NameDialogFragment extends DialogFragment {


    public interface AddNameFragmentActionButtonClickListener {

        void onPositiveClicked(String firstName, String lastName);

        void onNegativeClicked();
    }

    private View rootView;

    private AddNameFragmentActionButtonClickListener mListener;


    public static NameDialogFragment newInstance() {
        NameDialogFragment fragment = new NameDialogFragment();
        fragment.setTargetFragment(null, 0);
        return fragment;
    }

    public NameDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.screen_add_name_dialog, container, false);
        init();
        return rootView;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            if (getTargetFragment() != null)
                mListener = (AddNameFragmentActionButtonClickListener) getTargetFragment();
            else
                mListener = (AddNameFragmentActionButtonClickListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("activity or fragment must implement ActionButtonClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog d = getDialog();
        if (d != null) {
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
    // --- helpers ---
    private void init() {


        rootView.findViewById(R.id.positive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mListener != null) {
                    if (((EditText) rootView.findViewById(R.id.first_name)).getText().toString().equals("")) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.text_enter_fname), Toast.LENGTH_SHORT).show();
                    } else if (((EditText) rootView.findViewById(R.id.last_name)).getText().toString().equals("")) {
                        Toast.makeText(getActivity(), getResources().getString(R.string.text_enter_lname), Toast.LENGTH_SHORT).show();
                    } else {
                        mListener.onPositiveClicked(((EditText) rootView.findViewById(R.id.first_name)).getText().toString(), ((EditText) rootView.findViewById(R.id.last_name)).getText().toString());
                        dismiss();
                    }

                }
            }
        });

        rootView.findViewById(R.id.negative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mListener != null)
                    mListener.onNegativeClicked();
                dismiss();
            }
        });

    }

}
