package com.example.splash

interface Communicator {
    val isConnected: Boolean

    fun executeCommunicator()
    fun sendCommands(commands: Any)
}
