package com.example.herihomes.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herihomes.R;
import com.example.herihomes.models.User;
import com.example.herihomes.storage.SharedPrefManager;

public class ProfileActivity extends Activity {

    private TextView textViewName, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_profile);

        textViewName =findViewById(R.id.tv_name);
        textViewEmail =findViewById(R.id.tv_email);

        User user = SharedPrefManager.getInstance(this).getUser();

        textViewName.setText("Welcome " + user.getName());
        textViewEmail.setText(user.getEmail());




        final ImageView iV_dashboard =(ImageView)findViewById(R.id.iV_dashboard);
        iV_dashboard.setImageResource(R.drawable.dashboard);

        final ImageView iV_peter =(ImageView)findViewById(R.id.iV_peter);
        iV_peter.setImageResource(R.drawable.peter);



        final ImageView iv_pay = (ImageView)findViewById(R.id.iv_pay);
        iv_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PayRentActivity.class);
                ProfileActivity.this.startActivity(intent);
            }
        });
        final ImageView iv_pay_schedule = (ImageView)findViewById(R.id.iv_pay_schedule);
        iv_pay_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PaymentScheduleActivity.class);
                ProfileActivity.this.startActivity(intent);
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