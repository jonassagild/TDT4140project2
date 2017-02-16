package com.example.erikkjernlie.tdt4140project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikkjernlie on 15.02.2017.
 */

public class MainActivity extends Activity {
    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;
    private EditText input;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_activity); //referer her til layouten main activity

        lvProduct = (ListView) findViewById(R.id.listview_product);
        mProductList = new ArrayList<>();
        mProductList.add(new Product(1, "Hello, and welcome to uniBOT", 123, "What can I help you with?"));
        //mProductList.add(new Product(2, "iPhone 4", 210, "Apple 16 GB"));
        input = (EditText) findViewById(R.id.input);
        mProductList.add(new Product(2, input.toString(), 123, "Thank you."));


        //init adapter
        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //ex display msg with product id get from view.getTag
                Toast.makeText(getApplicationContext(), "Clicked product id "+ view.getTag(), Toast.LENGTH_SHORT).show();
                Intent b = new Intent(MainActivity.this, homescreen.class);
                startActivity(b);
            }
        });



    }
}
