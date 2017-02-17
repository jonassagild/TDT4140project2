package com.example.erikkjernlie.tdt4140project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
    private Button buttonMain;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_activity); //referer her til layouten main activity

        lvProduct = (ListView) findViewById(R.id.listview_product);
        mProductList = new ArrayList<>();
        mProductList.add(new Product(1, "Hello, and welcome to uniBOT", 123, "What can I help you with?"));
        //mProductList.add(new Product(2, "iPhone 4", 210, "Apple 16 GB"));
        input = (EditText) findViewById(R.id.input);
        buttonMain = (Button) findViewById(R.id.buttonMain);


        //init adapter
        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //ex display msg with product id get from view.getTag
                Toast.makeText(getApplicationContext(), "You sent this message at: "+ view.getTag(), Toast.LENGTH_SHORT).show();
                Intent b = new Intent(MainActivity.this, homescreen.class);
                startActivity(b);
            }
        });


        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProductList.add(new Product(3, input.getText().toString(), 1, "ok"));


                mProductList.add(returnProduct());
                adapter.notifyDataSetChanged();
                scrollMyListViewToBottom();
                //immediately add instant replay here

            }
        });
    }

    public Product returnProduct(){
        return new Product(4, "This is unibot talking", 5, "Autoresponse");
    }

    //automatically scrolls down when a messaged is sent
    private void scrollMyListViewToBottom() {
        lvProduct.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                lvProduct.setSelection(adapter.getCount() - 1);
            }
        });
    }
}
