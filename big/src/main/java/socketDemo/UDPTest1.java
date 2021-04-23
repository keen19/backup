package socketDemo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest1 {


    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的数据";
        byte[] data = str.getBytes();
        InetAddress inetAddress = InetAddress.getByName("192.168.1.126");
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inetAddress,8989);

        //发送数据
        socket.send(packet);
        //关闭资源
        socket.close();
    }


    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(8989);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        //接收数据

        socket.receive(packet);

        System.out.println(new String (packet.getData(),0,packet.getLength()));

        //关闭资源
        socket.close();
    }
}
