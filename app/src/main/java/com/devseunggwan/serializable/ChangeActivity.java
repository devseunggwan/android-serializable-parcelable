package com.devseunggwan.serializable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.devseunggwan.serializable.data.ParcelUser;
import com.devseunggwan.serializable.data.SerialableUser;

public class ChangeActivity extends AppCompatActivity {

    TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        textViews = new TextView[]{
                findViewById(R.id.res_id),
                findViewById(R.id.res_name),
                findViewById(R.id.res_age),
                findViewById(R.id.res_addr)
        };

        setText();

        findViewById(R.id.res_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setText(){
        Intent intent;
        intent = getIntent();
        // Parcelable
        if(intent.getIntExtra("req", 0) == 100){

            ParcelUser parcelUser = intent.getParcelableExtra("user");
            textViews[0].setText(parcelUser.user_id);
            textViews[1].setText(parcelUser.user_name);
            textViews[2].setText(parcelUser.user_age);
            textViews[3].setText(parcelUser.user_address);
            Toast.makeText(this, "Hello!, " + parcelUser.user_name, Toast.LENGTH_LONG).show();

        }

        // Serializable
        else if(intent.getIntExtra("req", 0) == 101){
            Bundle bundle = intent.getExtras();
            SerialableUser serialableUser = (SerialableUser) bundle.getSerializable("user");

            textViews[0].setText(serialableUser.getUser_id());
            textViews[1].setText(serialableUser.getUser_name());
            textViews[2].setText(serialableUser.getUser_age());
            textViews[3].setText(serialableUser.getUser_address());

            Toast.makeText(this, "Hello!, " + serialableUser.getUser_name(), Toast.LENGTH_LONG).show();

        }
    }
}
