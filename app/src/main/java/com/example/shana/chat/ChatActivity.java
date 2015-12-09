package com.example.shana.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by shana on 2015/12/9.
 */
public class ChatActivity extends Activity {
    public static final String CHAT_ACTIVITY_WORD_KEY = "CHAT_ACTIVITY_WORD_KEY";
    public static final int CHAT_ACTIVITY_SUCCESS_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextViewMessage(getIntent().getStringExtra(CHAT_ACTIVITY_WORD_KEY));

        Button button = (Button) findViewById(R.id.activity_main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishPageWithMessage(getMessageFromEditText());
            }
        });
    }

    private void setTextViewMessage(String message) {
        TextView text = (TextView) findViewById(R.id.activity_main_text);
        text.setText(message);
    }

    private String getMessageFromEditText() {
        EditText edit = (EditText) findViewById(R.id.activity_main_edit);
        return edit.getText().toString();
    }

    private void finishPageWithMessage(String message) {
        Intent intent = new Intent();
        intent.putExtra(CHAT_ACTIVITY_WORD_KEY, message);
        setResult(CHAT_ACTIVITY_SUCCESS_CODE, intent);
        finish();
    }
}
