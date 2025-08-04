package com.v2v.coinflipgame;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView coinImage;
    TextView resultText;
    Button flipButton;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinImage = findViewById(R.id.coinImage);
        resultText = findViewById(R.id.resultText);
        flipButton = findViewById(R.id.flipButton);
        random = new Random();

        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation flip = AnimationUtils.loadAnimation(MainActivity.this, R.anim.flip);
                coinImage.startAnimation(flip);

                coinImage.postDelayed(() -> {
                    boolean isHeads = random.nextBoolean();

                    if (isHeads) {
                        coinImage.setImageResource(R.drawable.heads);
                        resultText.setText("Heads");
                    } else {
                        coinImage.setImageResource(R.drawable.tails);
                        resultText.setText("Tails");
                    }
                }, 300);
            }
        });
    }
}