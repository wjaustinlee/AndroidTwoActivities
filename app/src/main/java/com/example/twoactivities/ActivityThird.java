package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ActivityThird extends AppCompatActivity {
    public static final int TEXTONE_REQUEST = 1;
    public static final int TEXTTWO_REQUEST = 2;
    public static final int TEXTTHREE_REQUEST = 3;
    private TextView scrollTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent textIntent = getIntent();
        int textCode = textIntent.getIntExtra(MainActivity.EXTRA_LONGTEXT, -1);
        scrollTextView = findViewById(R.id.third_scrollText);
        if (textCode == TEXTONE_REQUEST) {
            scrollTextView.setText(R.string.large_text);
        } else if (textCode == TEXTTWO_REQUEST) {
            scrollTextView.setText(R.string.article_text);
        } else if (textCode == TEXTTHREE_REQUEST) {
            scrollTextView.setText(R.string.textThree);
        } else {
            scrollTextView.setText("code failed");
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}
