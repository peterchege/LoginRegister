package com.example.herihomes.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herihomes.R;
import com.example.herihomes.models.User;
import com.example.herihomes.storage.SharedPrefManager;

public class MainActivity extends Activity {

    private TextView textViewName, textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        textViewName =findViewById(R.id.tv_name);
        textViewEmail =findViewById(R.id.tv_email);

        User user = SharedPrefManager.getInstance(this).getUser();

        textViewName.setText("Welcome " + user.getName());
        textViewEmail.setText(user.getEmail());




        final ImageView iV_dashboard =(ImageView)findViewById(R.id.iV_dashboard);
        iV_dashboard.setImageResource(R.drawable.dashboard);

        final ImageView iV_peter =(ImageView)findViewById(R.id.iV_peter);
        iV_peter.setImageResource(R.drawable.peter);

        final ImageView iv_chart =(ImageView)findViewById(R.id.iv_chart);
        iv_chart.setImageResource(R.drawable.chart);

        final ImageView iv_inbox =(ImageView)findViewById(R.id.iv_inbox);
        iv_inbox.setImageResource(R.drawable.inbox);

        final ImageView iv_setting =(ImageView)findViewById(R.id.iv_setting);
        iv_setting.setImageResource(R.drawable.settings);

        final ImageView iv_logout =(ImageView)findViewById(R.id.iv_logout);
        iv_logout.setImageResource(R.drawable.logout);
        iv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        final ImageView iv_account = (ImageView)findViewById(R.id.iv_account);
        iv_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        final ImageView iv_pay = (ImageView)findViewById(R.id.iv_pay);
        iv_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PayRentActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        final ImageView iv_pay_schedule = (ImageView)findViewById(R.id.iv_pay_schedule);
        iv_pay_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaymentScheduleActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
            startActivity(intent);
        }
    }
}
