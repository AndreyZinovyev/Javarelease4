package com.example.myapplication;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection {
    private  Socket  mSocket = null;
    private  String  mHost   = null;
    private  int     mPort   = 0;

    public static final String LOG_TAG = "SOCKET";

    public Connection() {}

    public Connection(final String host, final int port)
    {
        this.mHost = host;
        this.mPort = port;
    }

    // Метод открытия сокета
    public void openConnection() throws Exception
    {
        // Если сокет уже открыт, то он закрывается
        closeConnection();
        try {
            // Создание сокета
            mSocket = new Socket(mHost, mPort);
        } catch (IOException e) {
            throw new Exception("Невозможно создать сокет: "
                    + e.getMessage());
        }
    }
    /**
     * Метод закрытия сокета
     */
    public void closeConnection()
    {
        if (mSocket != null && !mSocket.isClosed()) {
            try {
                mSocket.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Ошибка при закрытии сокета :"
                        + e.getMessage());
            } finally {
                mSocket = null;
            }
        }
        mSocket = null;
    }
    /**
     * Метод отправки данных
     */
    public String getData2() {
        try {
            InputStream is = mSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String hello = br.readLine();

            is.close();
            isr.close();
            br.close();

            return hello;
        }
        catch (IOException e){return "Catch";}
    }
    public void sendData(byte[] data) throws Exception {

        new Thread(() -> {
            if (mSocket == null || mSocket.isClosed()) {
                try {
                    throw new Exception("Ошибка отправки данных. " +
                            "Сокет не создан или закрыт");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Отправка данных
            try {
                mSocket.getOutputStream().write(data);
                mSocket.getOutputStream().flush();
            } catch (IOException e) {
                try {
                    throw new Exception("Ошибка отправки данных : "
                            + e.getMessage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        closeConnection();
    }

    public void Add(){

    }

    public void Insert(){
        DataInputStream in;
        BufferedReader reader;

        try
        {
            in = new DataInputStream(mSocket.getInputStream());


        }
        catch (IOException e)    /* ... */
        {
            e.printStackTrace();
        }
    }

    public void Delete(){

    }}
