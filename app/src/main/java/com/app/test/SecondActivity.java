package com.app.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> mData = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "TEST", Toast.LENGTH_LONG).show();

            }
        });

        addItems();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*PopupMenu popupMenu = new PopupMenu(SecondActivity.this, findViewById(R.id.apps));
        popupMenu.inflate(R.menu.popmenu);
        Menu menu = popupMenu.getMenu();
        for(String country : mData){
            menu.add(country);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                return true;
            }
        });
        popupMenu.show();*/

        PopupWindow popupWindow = new PopupWindow(SecondActivity.this);
        popupWindow.setContentView(getLayoutInflater().inflate(R.layout.content_second, null));
        popupWindow.setWidth(500);
        popupWindow.setHeight(500);
        popupWindow.showAsDropDown(findViewById(R.id.apps));
        return true;
    }


    private void addItems(){
        mData.add("Asia");
        mData.add("aUSTRALIAdfgdfgdssdfsdfsdfsdfsyyyyyerererererererer");
        mData.add("america");
        mData.add("Asia");
        mData.add("aUSTRALIAdfgdfgdssdfsdfsdfsdfsyyyyyerererererererer");
        mData.add("america");
        mData.add("Asia");
        mData.add("aUSTRALIAdfgdfgdssdfsdfsdfsdfsyyyyyerererererererer");
        mData.add("america1");
        mData.add("Asia2");
        mData.add("aUSTRALIAdfgdfgdssdfsdfsdfsdfsyyyyyerererererererer");
        mData.add("america3");
        mData.add("Asia");
        mData.add("aUSTRALIAdfgdfgdssdfsdfsdfsdfsyyyyyerererererererer");
        mData.add("america");
        mData.add("Asia");
        mData.add("aUSTRALIAdfgdfgdssdfsdfsdfsdfsyyyyyerererererererer");
        mData.add("america5");
    }

}
