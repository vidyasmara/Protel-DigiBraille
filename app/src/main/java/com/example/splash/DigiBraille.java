package com.example.splash;

import android.app.Application;

public class DigiBraille extends Application {

    public Communicator communicator;

    @Override
    public void onCreate() {
        super.onCreate();

        communicator = BluetoothCommunicator.Companion.instance();
        communicator.executeCommunicator();
    }

    public Communicator getCommunicator() {
        return communicator;
    }
}