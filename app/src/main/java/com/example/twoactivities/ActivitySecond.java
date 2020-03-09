package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {
    private EditText mReply;
    public static final String EXTRA_REPLY = "com.example.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.second_editText);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.second_textMessage);
        textView.setText(message);
    }

    public void sendReply(View view) {
        String reply = mReply.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}
