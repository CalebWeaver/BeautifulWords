package com.bearlymade.beautifulwords;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    HaikuGenerator generator;
    TextView haikuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.new_button).setOnClickListener(this);
        generator = new HaikuGenerator(this);
        haikuView = (TextView) findViewById(R.id.haiku_view);
        haikuView.setText(generator.generateHaiku());
    }

    @Override
    public void onClick(View v) {
        haikuView.setText(generator.generateHaiku());
    }
}
