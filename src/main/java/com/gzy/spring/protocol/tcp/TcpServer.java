package com.gzy.spring.protocol.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/11/20 10:19
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        //创建一个服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("tcp端口8888已经启动....");

        while (true){
            //等待客户端请求，如果有接受请求，就分配一个socket
            Socket socket = serverSocket.accept();
            //根據标准输入构造一个bufferedReader对象
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //循环读取每一行数据
            String buffer = "";
            while((buffer = reader.readLine())!= null && !buffer.equals("")){
                System.out.println(buffer);
            }
            //通过socke对象得到输出流，构造bufferwriter对象
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //模拟http请求头的信息
            writer.write("HTTP/1.1 200 OK \r\n Content-Type:text/html \r\n charset=UTF-8 \r\n\r\n");
            //添加请求体
            writer.write("<html><head><title>http请求</title></head><body><h1>这是一个HTTP请求</h1></body></html>");
            //刷新数据流
            writer.flush();

            reader.close();
            writer.close();
            socket.close();

        }

    }
}
