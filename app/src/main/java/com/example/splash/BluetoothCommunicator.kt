package com.example.splash

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import java.io.IOException
import java.io.PrintStream

@SuppressLint("MissingPermission")
class BluetoothCommunicator : Communicator {

    private lateinit var bluetoothDevice: BluetoothDevice
    private lateinit var bluetoothSocket: BluetoothSocket
    private lateinit var sender: PrintStream

    private var bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

    private var connected = false
    override val isConnected: Boolean
        get() = connected


    override fun executeCommunicator() {
        connected = connectToPi()

        try {
            createSocket()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun sendCommands(commands: Any) {
        try {
            sender.print(commands as String)
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun createSocket() {
        try {
            val method = bluetoothDevice.javaClass.getMethod(
                    "createRfcommSocket",
                    Int::class.javaPrimitiveType
            )
            bluetoothSocket = method.invoke(bluetoothDevice, 1) as BluetoothSocket
        } catch (e: IOException) {
            e.printStackTrace()
        }

        BluetoothAdapter.getDefaultAdapter().cancelDiscovery()
        bluetoothSocket.connect()

        val outputStream = bluetoothSocket.outputStream
        sender = PrintStream(outputStream)
    }

    private fun connectToPi(): Boolean {
        val pairedDevices = bluetoothAdapter.bondedDevices
        for (device in pairedDevices) {
            if (device.name == "raspberrypi") {
                bluetoothDevice = device

                return true
            }
        }

        return false
    }

    companion object {
        fun instance() = BluetoothCommunicator()
    }
}