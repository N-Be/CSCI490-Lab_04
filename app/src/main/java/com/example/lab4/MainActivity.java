package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("youtube.com");


    }

    public String method (String entry){
        URL url = null;
        try {
            url = new URL(entry);
        }
        catch(java.net.MalformedURLException e){
            e.printStackTrace();
        }

        URLConnection connect = null;

        try{
            connect = url.openConnection();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        InputStreamReader inputStreamReader = null;

        try{
            inputStreamReader = new InputStreamReader((connect.getInputStream()));
        }
        catch(IOException e){
            e.printStackTrace();;
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;

        try{
            line = bufferedReader.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }



        Log.i(null,line);

        return line;

    }




}
