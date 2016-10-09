package com.example.guitarman.gnm1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LineRotate extends AppCompatActivity implements View.OnTouchListener {

    Canvas c;
    Paint paint;
    private float x1[] =new float[100],y1[]=new float[100],x2[]=new float[100],y2[]=new float[100];
    int flag=0;
    ImageView iv;
    RotateAnimation anim;
    float pivotx,pivoty;
    EditText tv,tv1;
    private Editable x;
    private Editable y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_rotate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iv=(ImageView)findViewById(R.id.imageView1);
        tv=(EditText) findViewById(R.id.editText);
        tv1=(EditText) findViewById(R.id.editText2);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Draw a Line to observe Rotation", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Display currentDisplay = getWindowManager().getDefaultDisplay();
        float dw = currentDisplay.getWidth();
        float dh = currentDisplay.getHeight();

        Bitmap b= Bitmap.createBitmap((int) dw, (int) dh,
                Bitmap.Config.ARGB_8888);
        //Bitmap b= Bitmap.createtmap(screenWidth,screenHeight,Bitmap.Config.ARGB_8888);
        c=new Canvas(b);

        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        iv.setImageBitmap(b);
        iv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
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
                pivotx=(x1[flag]+x2[flag])/2;
                pivoty=(y1[flag]+y2[flag])/2;
                //c.drawLine(500,600,0,0,paint);
                flag++;
                iv.invalidate();

                anim=new RotateAnimation(0.0f,350.0f,pivotx,pivoty);
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatCount(Animation.INFINITE);
                anim.setDuration(1000);
      iv.startAnimation(anim);







                break;

            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return true;
    }
}
