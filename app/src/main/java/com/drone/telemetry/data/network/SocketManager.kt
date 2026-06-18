package com.drone.telemetry.data.network

import java.net.DatagramSocket

class SocketManager {

    private var socket: DatagramSocket? = null

    fun connect(port: Int): Boolean {

        return try {

            socket = DatagramSocket(port)

            true

        } catch (e: Exception) {

            e.printStackTrace()

            false
        }
    }

    fun disconnect() {

        socket?.close()

        socket = null
    }

    fun isConnected(): Boolean {

        return socket != null &&
                !socket!!.isClosed
    }
}