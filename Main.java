package com.example.guitarman.gnm1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=(Button)findViewById(R.id.button7);
        b2=(Button)findViewById(R.id.button8);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main.this,LineDraw.class);
                startActivity(i);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main.this,CircleDraw.class);
                startActivity(i);


            }
        });


    }
}
