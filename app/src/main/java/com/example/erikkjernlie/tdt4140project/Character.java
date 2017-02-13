package com.example.erikkjernlie.tdt4140project;

import android.print.PrintManager;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by J¯rgen on 09.02.2017.
 */

public class Character {

    private TextView textView;

    public Character(TextView textView) {
        this.textView = textView;
    }

    public void run() {
        textView.setText("hei");

    }
}
