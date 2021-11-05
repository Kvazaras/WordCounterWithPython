package com.example.wordcounterwithpython;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    Python py;
    PyObject module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        this.py = Python.getInstance();
        this.module = this.py.getModule("counter");
    }

    public void onBtnCountClick(View view) {
        EditText edInput = findViewById(R.id.edInput);
        TextView tvResult = findViewById(R.id.tvResult);
        String input = edInput.getText().toString();

        Integer charsCount = this.module.callAttr("countchars", input).toJava(Integer.class);
        Integer wordsCount = this.module.callAttr("countwords", input).toJava(Integer.class);

        tvResult.setText(String.format("Chars count %s, Words count %s", charsCount, wordsCount));
    }
}