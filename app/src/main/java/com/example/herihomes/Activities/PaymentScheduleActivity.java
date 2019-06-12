package com.example.herihomes.Activities;

import android.app.Activity;
import android.support.annotation.RequiresFeature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.herihomes.R;


public class PaymentScheduleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_payment_schedule);
    }
}
