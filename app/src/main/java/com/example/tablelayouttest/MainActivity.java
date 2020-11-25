package com.example.tablelayouttest;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2;
    AnimationDrawable ani1, ani2;
    int[] ani;
    Random rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ani = new int[]{R.drawable.anim1, R.drawable.anim2, R.drawable.anim3};
        rand = new Random();

        img1 = (ImageView)findViewById(R.id.imageView4);
        img2 = (ImageView)findViewById(R.id.imageView5);
        img1.setImageResource(ani[rand.nextInt(3)]);
        img2.setImageResource(ani[rand.nextInt(3)]);
        ani1 = (AnimationDrawable)img1.getDrawable();
        ani2 = (AnimationDrawable)img2.getDrawable();
    }


    public void onClick(View view) throws InterruptedException {
        TextView textView = (TextView) findViewById(R.id.textView4);
        int i = Integer.parseInt((String) textView.getText());
        textView.setText(String.valueOf(i + 1));
        if (ani1.isRunning()) {
            Toast.makeText(getApplicationContext(), "stop", Toast.LENGTH_SHORT).show();
            ani1.stop();
            ani2.stop();
        } else {
            Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_SHORT).show();
            img1.setImageResource(ani[rand.nextInt(3)]);
            img2.setImageResource(ani[rand.nextInt(3)]);
            ani1 = (AnimationDrawable)img1.getDrawable();
            ani2 = (AnimationDrawable)img2.getDrawable();
            ani1.setOneShot(true);
            ani2.setOneShot(true);
            ani1.start();
            ani2.start();

//            ani1.stop();
//            ani2.stop();
        }
    }
}