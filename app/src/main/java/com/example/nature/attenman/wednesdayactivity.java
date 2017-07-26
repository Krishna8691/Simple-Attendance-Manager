package com.example.nature.attenman;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class wednesdayactivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    DBHelperWednesday mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;

    DBHelperWednesday mmDatabaseHelper;

    private ListView mListView;

    Handler h = new Handler();
    int delay = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesdayactivity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.rgb(40,40,40));
        }


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.back)));

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDatabaseHelper = new DBHelperWednesday(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("Please Enter a Subject Name!");
                }

            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wednesdayactivity.this, ListDataActivitywednesday.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        mListView = (ListView) findViewById(R.id.subnames);
        mmDatabaseHelper = new DBHelperWednesday(this);
        //populateListViewmv();




        /*h.postDelayed(new Runnable(){
            public void run(){
                populateListViewmv();
                h.postDelayed(this, delay);
            }
        }, delay);*/
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Subject Added!");
        } else {
            toastMessage("Subject Not Added");
        }
    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }




    /*private void populateListViewmv() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(wednesdayactivity.this, EditDataActivitywednesday.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    editScreenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    editScreenIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID Associated With Subject");
                }
            }
        });
    }*/
}
