package com.example.shana.chat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by shana on 2015/12/9.
 */
public class Chat extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.activity_main_button);
        EditText edit = (EditText) findViewById(R.id.activity_main_edit);
        TextView text = (TextView) findViewById(R.id.activity_main_text);
    }
}
