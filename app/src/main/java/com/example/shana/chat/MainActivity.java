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
public class MainActivity extends Activity {
    @Bind(R.id.activity_main_text)
    TextView textView;

    @Bind(R.id.activity_main_edit)
    EditText editText;

    @OnClick(R.id.activity_main_button)
    void onSendMessage() {
        sendMessageToNextPage(editText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void sendMessageToNextPage(String message) {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra(ChatActivity.CHAT_ACTIVITY_WORD_KEY, message);
        startActivityForResult(intent, ChatActivity.CHAT_ACTIVITY_SUCCESS_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ChatActivity.CHAT_ACTIVITY_SUCCESS_CODE) {
            textView.setText(data.getStringExtra(ChatActivity.CHAT_ACTIVITY_WORD_KEY));
        }
    }
}
