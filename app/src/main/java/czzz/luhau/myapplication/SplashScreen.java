package czzz.luhau.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView tvslogan;
    ImageView imvlogo;
    Animation frombt, fromtop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,Login_Activity.class);
                startActivity(i);
                finish();
            }
        },2000);

        tvslogan=findViewById(R.id.mySlogan);
        imvlogo=findViewById(R.id.myLogo);

        frombt= AnimationUtils.loadAnimation(this,R.anim.frombt);
        fromtop=AnimationUtils.loadAnimation(this,R.anim.fromtop);

        tvslogan.setAnimation(frombt);
        imvlogo.setAnimation(fromtop);


    }
}
