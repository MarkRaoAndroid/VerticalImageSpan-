package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatEditText editText;
    private SimpleTextView simpleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editInput);
        simpleTextView = findViewById(R.id.textView);
        findViewById(R.id.btnTest).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnTest){
            onBtnTestClick();
        }
    }

    private void onBtnTestClick() {
        simpleTextView.setTextContent(editText.getText());
    }

}