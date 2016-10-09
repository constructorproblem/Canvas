package com.example.guitarman.gnm1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LineDraw extends AppCompatActivity implements View.OnTouchListener{
   // TextView tv;
    ImageView  iv;
    Button b;
    Button b1;
    Canvas c;
    Paint paint;
    private float x1[] =new float[100],y1[]=new float[100],x2[]=new float[100],y2[]=new float[100];
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageView1);
        b=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button2);


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
        iv.setOnTouchListener(this);









        //trying to draw on a canvas screen



        //c.drawRect(150,50,1000,100,paint);
        //c.drawLine(x1[0],y1[0],x1[1],y1[1],paint);




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

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i=new Intent(LineDraw.this,LineRotate.class);
                                startActivity(i);


                            }
                        });

                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v1) {
                                Intent i1=new Intent(LineDraw.this,LineScale.class);
                                startActivity(i1);


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


