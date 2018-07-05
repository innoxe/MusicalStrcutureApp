package com.example.android.musicalstrcutureapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the Views that shows the Musics category
        ImageButton blues = (ImageButton) findViewById(R.id.blues);
        ImageButton jazz = (ImageButton) findViewById(R.id.jazz);
        ImageButton pop = (ImageButton) findViewById(R.id.pop);
        ImageButton rock = (ImageButton) findViewById(R.id.rock);
        ImageButton rap = (ImageButton) findViewById(R.id.rap);
        ImageButton folk = (ImageButton) findViewById(R.id.folk);
        ImageButton classical = (ImageButton) findViewById(R.id.classical);

        // Set a click listener on that View
        blues.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                 Intent numbersIntent = new Intent(MainActivity.this, BluesActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on that View
        jazz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, JazzActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on that View
        pop.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, PopActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on that View
        rock.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, RockActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on that View
        rap.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, RapActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on that View
        folk.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, FolkActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on that View
        classical.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, ClassicalActivity.class);
                startActivity(numbersIntent);
            }
        });
    }
}
