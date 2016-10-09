package com.example.guitarman.gnm1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CircleDraw extends AppCompatActivity implements View.OnTouchListener {
    RotateAnimation anim;
    float pivotx,pivoty;
    ImageView iv;
    Canvas c;
    Paint paint;
    private double x1[] = new double[100], y1[] = new double[100], x2[] = new double[100], y2[] = new double[100];
    int flag = 0;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_draw);

        iv = (ImageView) findViewById(R.id.imageView1);
        b=(Button)findViewById(R.id.button10);
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        float dw = currentDisplay.getWidth();
        float dh = currentDisplay.getHeight();


        Bitmap b = Bitmap.createBitmap((int) dw, (int) dh,
                Bitmap.Config.ARGB_8888);
        //Bitmap b= Bitmap.createtmap(screenWidth,screenHeight,Bitmap.Config.ARGB_8888);
        c = new Canvas(b);

        paint = new Paint();
        paint.setColor(Color.CYAN);
        iv.setImageBitmap(b);
        iv.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                x1[flag] = event.getX();
                y1[flag] = event.getY();
                Toast.makeText(this, "X is" + x1[flag] + "Y is" + y1[flag], Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                x2[flag] = event.getX();
                y2[flag] = event.getY();
                Toast.makeText(this, "X2 is" + x2[flag] + "Y2 is" + y2[flag], Toast.LENGTH_SHORT).show();
                double radi=Math.sqrt(Math.pow(x2[flag]-x1[flag],2)+Math.pow(x2[flag]-x1[ flag],2));

                //LinearLayout l=(LinearLayout)findViewById(R.id.activity_main);
                //l.setBackground(new BitmapDrawable(b));
                //c.drawLines();
                //c.drawRect(100,50,150,200,paint);
                //c.drawLine(x1[flag], y1[flag], x2[flag], y2[flag], paint);
                final float cx=iv.getWidth()/2;
                final float cy=iv.getHeight()/2;
                c.drawCircle(cx,cy,(float)radi,paint);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        anim=new RotateAnimation(0.0f,350.0f,cx,cy);
                        anim.setInterpolator(new LinearInterpolator());
                        anim.setRepeatCount(Animation.INFINITE);
                        anim.setDuration(1000);
                        iv.startAnimation(anim);



                    }
                });

                //c.drawLine(00,600,0,0,paint);
                flag++;
                iv.invalidate();

        }
        return true;
    }
}
