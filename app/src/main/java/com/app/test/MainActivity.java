package com.app.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONObject mainData = null;
        try {
            JSONObject jsonObject = new JSONObject(DATA.JSON_DATA);
            mainData = jsonObject.getJSONObject("text");
            Log.v("data_", "before: " + mainData.toString());
            Log.v("data_", "original length: " + Integer.toString(mainData.length()));
            Iterator iterator = mainData.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                mainData.put(key, "");
            }

            Log.v("data_", "after: " + mainData.toString());


        } catch (JSONException exception) {
            exception.printStackTrace();
        }


        /********************************/
        HashMap<String, String> metaMap = new HashMap<String, String>();

        try {
            JSONArray jsonArray = new JSONArray(DATA.META_DATA);
            Log.v("data_", "meta data length " + Integer.toString(jsonArray.length()));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                metaMap.put(jsonObject.getString("key"), jsonObject.getString("value"));
            }

            Log.v("data_", "map length " + metaMap.size());

        } catch (JSONException exception) {
            Log.v("exception_", "exception2");
            exception.printStackTrace();
        }

        JSONObject jsonObjectToCompare = null;
        try {
            jsonObjectToCompare = new JSONObject(metaMap);
            Log.v("data_", "final json: " + jsonObjectToCompare.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.v("exception_", "exception3");
        }

        ArrayList<String> missingKeys = new ArrayList<>();
        try {
            JSONObject finalJsonObject = new JSONObject();
            Iterator originalDataIterator = mainData.keys();
            while (originalDataIterator.hasNext()) {
                String originalKey = (String) originalDataIterator.next();
                if (jsonObjectToCompare.has(originalKey)) {
                    finalJsonObject.put(originalKey, jsonObjectToCompare.getString(originalKey));
                } else {
                    finalJsonObject.put(originalKey, "");
                    missingKeys.add(originalKey);
                }
            }

            Log.v("data_", "output_ " + finalJsonObject.toString());
            Log.v("data_", "output length_ " + finalJsonObject.length());
            Log.v("data_", "missing keys " + missingKeys.toString());
            Log.v("data_", "missing keys length " + missingKeys.size());

        } catch (Exception exception) {
            exception.printStackTrace();
            Log.v("exception_", "exception4");
        }
    }

}
