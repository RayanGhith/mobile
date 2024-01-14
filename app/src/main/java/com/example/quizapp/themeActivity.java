package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class themeActivity extends AppCompatActivity {

    public Button btn;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_theme);

        btn=(Button) findViewById(R.id.btn_choose1);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            Intent intent = new Intent(themeActivity.this,playActivity.class);
            startActivity(intent);
        }
    });
    }

}
