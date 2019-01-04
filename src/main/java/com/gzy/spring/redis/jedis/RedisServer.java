package com.gzy.spring.redis.jedis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Discribe
 * @Author gzy
 * @Date 2019/1/4 14:14
 */
public class RedisServer {

    public static void main(String[] args) {

        try {
            ServerSocket socket = new ServerSocket(6379);

            Socket accept = socket.accept();
            byte[] result = new byte[2048];

            accept.getInputStream().read(result);

            System.out.println(new String(result));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
