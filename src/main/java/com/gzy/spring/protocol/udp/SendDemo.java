package com.gzy.spring.protocol.udp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/20 13:23
 */
public class SendDemo {


    public static void main(String[] args) throws IOException {
        //创建datagraSocket，用来接收数据
        DatagramSocket socket = new DatagramSocket();
        //键盘输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String buffer = null;

        while ((buffer = reader.readLine())!= null){
            //获取输入的数据
            byte[] bytes = buffer.getBytes();
            //创建一个用于发送数据的datagramPacket
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),10005);
            //发送数据
            socket.send(packet);
            //当输入的额内容是“88”的时候就退出循环
            if ("88".equals(buffer)){
                break;
            }
            System.out.println("发送的数据是："+buffer);
        }
        reader.close();
        socket.close();
    }

}
