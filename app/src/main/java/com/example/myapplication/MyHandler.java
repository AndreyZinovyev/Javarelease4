package com.example.myapplication;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.myapplication.databinding.ActivityMainBinding;
import android.util.Log;
import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MyHandler {
    String st;

    private com.example.myapplication.Connection mConnect;
    private  String     HOST      = "10.0.2.2";
    private  int        PORT      = 8005;

    private  String     LOG_TAG   = "SOCKET";
    public MyHandler(){

        mConnect = new Connection(HOST, PORT);
        // Открытие сокета в отдельном потоке
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mConnect.openConnection();
                    Log.d(LOG_TAG, "Соединение установлено");
                    Log.d(LOG_TAG, "(mConnect != null) = "
                            + (mConnect != null));
                } catch (Exception e) {
                    Log.e(LOG_TAG, e.getMessage());
                    mConnect = null;
                }
            }
        }).start();*/
    }
    public String onClick(String a) {
        if (mConnect == null) {
            Log.d(LOG_TAG, "Соединение не установлено");
        }  else {
            Log.d(LOG_TAG, "Отправка сообщения");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mConnect.openConnection();
                        Log.d(LOG_TAG, "Соединение установлено");
                        Log.d(LOG_TAG, "(mConnect != null) = "
                                + (mConnect != null));
                        String text;
                        // text = __binding.editTextTextPersonName.getText().toString();
                        text="0;qwerty";
                        // отправляем сообщение
                        text="0;"+a;
                        mConnect.sendData(text.getBytes());
                        st=mConnect.getData2();
                        mConnect.closeConnection();
                    } catch (Exception e) {
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            }).start();
        }
        //  String a;
        //   String b;
        //      __binding.textView2.setText("Ура");
    /*a= __binding.editTextTextPersonName.getText().toString();

        b=  __binding.editTextTextPersonName2.getText().toString();
        Toast toast = Toast.makeText(view.getContext(),
                a+b, Toast.LENGTH_SHORT);
        toast.show();*/
        try {
            Thread.sleep(1000); //Приостанавливает поток на 1 секунду
        } catch (Exception e) {

        }
        String s = st;
   return s;

    }


    public String  onClickRecycle(){
    //public ArrayList<Cars>  onClickRecycle(){
        if (mConnect == null) {
            Log.d(LOG_TAG, "Соединение не установлено");
        }  else {
            Log.d(LOG_TAG, "Отправка сообщения");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String text;
                        mConnect.openConnection();
                        // text = __binding.editTextTextPersonName.getText().toString();
                        text="0;qwerty";
                        // отправляем сообщение
                        text="3;77";
                        mConnect.sendData(text.getBytes());
                        st=mConnect.getData2();

                        mConnect.closeConnection();

                    } catch (Exception e) {
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000); //Приостанавливает поток на 1 секунду
        } catch (Exception e) {

        }
        String s = st;
        /*  String[] dd = s.split(":");
        ArrayList<Cars> d = new ArrayList<Cars>();
        for(int ii = 0; ii < dd.length-1;ii++)
        {
            String[] q = dd[ii].split(";");
            d.add(new Cars(Integer.parseInt(q[0]),q[1],"123"));
        } */

        return s;
    }
}