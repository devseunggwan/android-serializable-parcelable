package com.devseunggwan.serializable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devseunggwan.serializable.data.ParcelUser;
import com.devseunggwan.serializable.data.SerialableUser;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText[] editTexts;

    ParcelUser parcelUser;
    SerialableUser serialableUser;

    static final int REQ_CODE_PAR = 100;
    static final int REQ_CODE_SER = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexts = new EditText[]{
                findViewById(R.id.user_id),
                findViewById(R.id.user_name),
                findViewById(R.id.user_age),
                findViewById(R.id.user_addr),
        };



        findViewById(R.id.user_par).setOnClickListener(this);
        findViewById(R.id.user_ser).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ArrayList<String> arr = new ArrayList<>();
        for(EditText ed : editTexts) arr.add(ed.getText().toString());
        Intent intent;
        Bundle bundle;
        switch (v.getId()){
            case R.id.user_par:
                parcelUser = new ParcelUser();
                parcelUser.user_id = arr.get(0);
                parcelUser.user_name = arr.get(1);
                parcelUser.user_age = arr.get(2);
                parcelUser.user_address = arr.get(3);

                intent = new Intent(this, ChangeActivity.class);
                intent.putExtra("user", parcelUser);
                intent.putExtra("req", REQ_CODE_PAR);
                startActivity(intent);

                break;

            case R.id.user_ser:
                serialableUser = new SerialableUser(arr.get(0), arr.get(1), arr.get(2), arr.get(3));

                bundle = new Bundle();
                bundle.putSerializable("user", serialableUser);

                intent = new Intent(this, ChangeActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("req", REQ_CODE_SER);
                startActivity(intent);

                break;
        }
    }
}
