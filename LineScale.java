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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LineScale extends AppCompatActivity implements View.OnTouchListener{
    int scalex=0,scaley=0;
    ImageView iv;
    Button px,py,mx,my;
    Canvas c;
    Paint paint;
    private float x1[] =new float[100],y1[]=new float[100],x2[]=new float[100],y2[]=new float[100];
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_scale);
        iv=(ImageView)findViewById(R.id.imageView1);
        px=(Button)findViewById(R.id.button3);
        py=(Button)findViewById(R.id.button4);
        mx=(Button)findViewById(R.id.button5);
        my=(Button)findViewById(R.id.button6);

        Display currentDisplay = getWindowManager().getDefaultDisplay();
        float dw = currentDisplay.getWidth();
        float dh = currentDisplay.getHeight();

        Bitmap b= Bitmap.createBitmap((int) dw, (int) dh,
                Bitmap.Config.RGB_565);
        //Bitmap b= Bitmap.createtmap(screenWidth,screenHeight,Bitmap.Config.ARGB_8888);
        c=new Canvas(b);

        paint=new Paint();
        paint.setColor(Color.CYAN);
        iv.setImageBitmap(b);
        iv.setOnTouchListener((View.OnTouchListener) this);
    }



    public boolean onTouch(View v,MotionEvent event) {

        int action= event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                x1[flag]= event.getX();
                y1[flag] = event.getY();
                Toast.makeText(this, "X is" + x1[flag] + "Y is" + y1[flag], Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                x2 [flag]= event.getX();
                y2 [flag] = event.getY();
                Toast.makeText(this, "X2 is" + x2[flag] + "Y2 is" + y2[flag], Toast.LENGTH_SHORT).show();



                //LinearLayout l=(LinearLayout)findViewById(R.id.activity_main);
                //l.setBackground(new BitmapDrawable(b));
                //c.drawLines();
                //c.drawRect(100,50,150,200,paint);
                c.drawLine(x1[flag],y1[flag],x2[flag],y2[flag],paint);
                //c.drawLine(500,600,0,0,paint);
                flag++;
                iv.invalidate();
                px.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       iv.setScaleX(scalex);
                        scalex++;
                    }
                });

                py.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iv.setScaleX(scaley);
                        scaley++;
                    }
                });

                mx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iv.setScaleX(scalex);
                        scalex--;
                    }
                });

                my.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iv.setScaleX(scaley);
                        scaley--;
                    }
                });



                break;

            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }









        return true;
    }



}

