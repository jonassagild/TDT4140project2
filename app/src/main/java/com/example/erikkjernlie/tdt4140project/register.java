package com.example.erikkjernlie.tdt4140project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView txview = (TextView) findViewById(R.id.textView5);
        Character character = new Character(txview);
        character.run();


        //er noen endringer her ja


    }

    public void btnClickMe(View v){
        EditText input = (EditText) findViewById(R.id.input);
        TextView output = (TextView) findViewById(R.id.output);
        output.setText("Hello " + input.getText());
    }
}
