package com.example.shana.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/9.
 */
public class ChatActivity extends Activity {
    public static final String CHAT_ACTIVITY_WORD_KEY = "CHAT_ACTIVITY_WORD_KEY";
    public static final int CHAT_ACTIVITY_SUCCESS_CODE = 777;

    @Bind(R.id.activity_main_text)
    TextView textView;

    @Bind(R.id.activity_main_edit)
    EditText editText;

    @OnClick(R.id.activity_main_button)
    void onSendMessage() {
        finishPageWithMessage(editText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textView.setText((getIntent().getStringExtra(CHAT_ACTIVITY_WORD_KEY)));
    }

    private void finishPageWithMessage(String message) {
        Intent intent = new Intent();
        intent.putExtra(CHAT_ACTIVITY_WORD_KEY, message);
        setResult(CHAT_ACTIVITY_SUCCESS_CODE, intent);
        finish();
    }
}
