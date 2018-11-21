package com.gzy.spring.protocol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/20 11:40
 */
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {
        //创建一个datagramSocket，并打实例绑定到本地，端口10005
        DatagramSocket datagramSocket = new DatagramSocket(10005);
        byte[] bytes = new byte[1024];
        //创建一个datagramPacket用来接收，datagramSocket中的数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

        while (true){

            //接收到数据包
            datagramSocket.receive(datagramPacket);
            //获取接收数据
            byte[] data = datagramPacket.getData();

            //把数组转换为字符串
            String value = new String(data, 0, data.length);
            //如果数据包中是“88”的信息，则退出循环
            if ("88".equals(value)){
                break;
            }

            System.out.println("接收到的数据是："+value);
        }
        datagramSocket.close();

    }

}
