package com.gzy.spring.redis.jedis;

import java.io.IOException;
import java.net.Socket;

/**
 * @Discribe
 * @Author gzy
 * @Date 2019/1/4 14:21
 */
public class RedisClient {

    public static String set(Socket socket, String key, String value) throws IOException{
        StringBuffer str  = new StringBuffer();
        str.append("*3").append("\r\n");
        str.append("$3").append("\r\n");
        str.append("set").append("\r\n");
        //key
        str.append("$").append(key.getBytes().length).append("\r\n");
        str.append(key).append("\r\n");
        //value
        str.append("$").append(value.getBytes().length).append("\r\n");
        str.append(value).append("\r\n");

        //向redis发送resp
        socket.getOutputStream().write(str.toString().getBytes());
        byte[] response = new byte[2048];
        socket.getInputStream().read(response);

        return new String(response);
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",6379);
            set(socket,"light","123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
