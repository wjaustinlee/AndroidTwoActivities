package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.twoactivities.extra.MESSAGE";
    public static final String EXTRA_LONGTEXT = "com.example.twoactivities.extra.LONGTEXT";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView mReplyTextDisplay;
    private TextView mReplyTextHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.main_editText);
        mReplyTextHeader = findViewById(R.id.first_replyTextHeader);
        mReplyTextDisplay = findViewById(R.id.first_replyTextDisplay);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, ActivitySecond.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
//        Log.d(LOG_TAG, "Button Clicked!");
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(ActivitySecond.EXTRA_REPLY);
                mReplyTextHeader.setVisibility(View.VISIBLE);
                mReplyTextDisplay.setText(reply);
                mReplyTextDisplay.setVisibility(View.VISIBLE);
            }
        }
    }

    public void displayTextOne(View view) {
        launchThirdActivity(view, ActivityThird.TEXTONE_REQUEST);
    }

    public void displayTextTwo(View view) {
        launchThirdActivity(view, ActivityThird.TEXTTWO_REQUEST);
    }
    
    public void displayTextThree(View view) {
        launchThirdActivity(view, ActivityThird.TEXTTHREE_REQUEST);
    }

    private void launchThirdActivity(View view, int textRequestCode) {
        Intent textIntent = new Intent(this, ActivityThird.class);
        textIntent.putExtra(EXTRA_LONGTEXT, textRequestCode);
        startActivity(textIntent);
    }
}
