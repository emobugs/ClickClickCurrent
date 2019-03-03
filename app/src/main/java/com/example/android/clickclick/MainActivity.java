package com.example.android.clickclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void playNow(View view) {


        EditText bluePlayerName = findViewById(R.id.enter_name_blue_edit_text);
        final String blueName = bluePlayerName.getText().toString();

        EditText redPlayerName = findViewById(R.id.enter_name_red_edit_text);
        final String redName = redPlayerName.getText().toString();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, FirstGameActivity.class);
        intent.putExtra("blueName", blueName);
        intent.putExtra("redName", redName);
        startActivity(intent);
    }
//        });
//    }


}
