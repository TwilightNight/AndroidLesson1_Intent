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
public class Main extends Activity {
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

        TextView text = (TextView) findViewById(R.id.activity_main_text);
    }

    private String getMessageFromEditText(){
        EditText edit = (EditText) findViewById(R.id.activity_main_edit);
        return edit.getText().toString();
    }

    private void sendMessageToNextPage(String message){
        Intent intent = new Intent(this, Chat.class);
        intent.putExtra("Words", message);
        startActivity(intent);
    }
}
