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
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.activity_main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageToNextPage(getMessageFromEditText());
            }
        });
    }

    private void setTextViewMessage(String message) {
        TextView text = (TextView) findViewById(R.id.activity_main_text);
        text.setText(message);
    }

    private String getMessageFromEditText(){
        EditText edit = (EditText) findViewById(R.id.activity_main_edit);
        return edit.getText().toString();
    }

    private void sendMessageToNextPage(String message){
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra(ChatActivity.CHAT_ACTIVITY_WORD_KEY, message);
        startActivityForResult(intent, ChatActivity.CHAT_ACTIVITY_SUCCESS_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ChatActivity.CHAT_ACTIVITY_SUCCESS_CODE) {
            setTextViewMessage(data.getStringExtra(ChatActivity.CHAT_ACTIVITY_WORD_KEY));
        }
    }
}
