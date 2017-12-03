package com.example.administrator.yoiexchang.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.yoiexchang.R;

/**
 * Created by Administrator on 03/12/2017.
 */

public class MainFragment extends Fragment{
    //ประกาศตัวแปร

    private RadioGroup radioGroup;
    private RadioButton usdRadioButton, thbRadioButton;
    private EditText editText;
    private Button button;
    private double factorADouble;
    private static double usdADouble = 33;
    private String moneySting;
    //สร้างเมดทอดหลักในการจัดการ การทำงาน
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //initial view
        initialView();
        //usd to thb
        usdToThb();
        //usd
        usd();
        //thb
        thb();
        // button
        button();

        //    rate
        rate();
    }//เมดตอดหลัก main method

    private void rate() {
        TextView textView = getView().findViewById(R.id.txtrate);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new showRateExchang())
                        .addToBackStack(null).commit();
            }
        });
    }


    private void usd() {
        usdRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setHint(getString(R.string.usd));
                factorADouble = 1/ usdADouble;
            }//usd
        });
    }

    private void thb() {
        thbRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setHint(getString(R.string.thb));
                factorADouble =  usdADouble;
            }//thb
        });
    }

    private void button() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get value from edittext
                moneySting = editText.getText().toString().trim();
                //check space
                if (moneySting.isEmpty()) {
                    //have space

                    myAlertDialog("have space", "please fill all blank");

                } else {
                    //no space
                    calculate();
                }

            }//onclick
        });
    }

    private void calculate() {
        String tag = "3Decv1";
        Log.d(tag, "favtor ==> " + factorADouble);
        double answerADoule = Double.parseDouble(moneySting) * factorADouble;
        myAlertDialog("Answer", "money =  " + Double.toString(answerADoule));






    }//calculate

    private void myAlertDialog(String strTitle, String strMessag) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(strTitle);
        builder.setMessage(strMessag);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();

    }
    private void usdToThb() {
       usdRadioButton.setChecked(true);
       factorADouble =  usdADouble;




    }

    private void initialView() {
        radioGroup = getView().findViewById(R.id.ragMoney);
        usdRadioButton = getView().findViewById(R.id.USD);
        thbRadioButton = getView().findViewById(R.id.THB);
        editText = getView().findViewById(R.id.edtMoney);
        button = getView().findViewById(R.id.btnExchange);
    }

    //สร้างหน้ากาก
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
                    , @Nullable ViewGroup container
                    , @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        return view;
    }
}   //main class คือคลาสหลัก
