package com.example.administrator.yoiexchang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.yoiexchang.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        add fragment to activity
        if (savedInstanceState == null){
//            Condition is True
         getSupportFragmentManager()
                 .beginTransaction()
                 .add(R.id.contentMainFragment, new MainFragment())
                 .commit();


        } //if
    }   //main method
}   //main class
