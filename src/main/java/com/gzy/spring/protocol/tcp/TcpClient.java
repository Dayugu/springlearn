package com.gzy.spring.protocol.tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/20 11:19
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        String mes = "Hello 13号！";
        //创建一个socket与本机的8888端口进行连接
        Socket socket = new Socket("localhost", 8888);
        //使用socket创建一个输出流，进行写数据
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        //发送数据
        writer.println(mes);
        //刷新一下，使服务器可以马上收到请求
        writer.flush();

        //关闭资源
        writer.close();
        socket.close();
    }
}
