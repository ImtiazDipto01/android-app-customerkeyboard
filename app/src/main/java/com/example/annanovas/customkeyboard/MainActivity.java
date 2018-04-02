package com.example.annanovas.customkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyKeyboard keyboard ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText);
        keyboard = (MyKeyboard) findViewById(R.id.keyboard);
        keyboard.setVisibility(View.GONE);

        // prevent system keyboard from appearing when EditText is tapped
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboard.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(keyboard.getVisibility() == View.VISIBLE){
            keyboard.setVisibility(View.GONE);
        }
    }
}
