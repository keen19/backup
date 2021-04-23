package socketDemo;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {
    @Test
    public void  client() throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName, 8889);
        OutputStream outputStream = socket.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("src/main/java/socketDemo/2.txt"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //接收服务器发送的数据

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte [] buffer = new byte[10];
        int length;
        while ((length=inputStream.read(buffer))!=-1){
            baos.write(buffer,0,length);
        }



        System.out.println(baos.toString());
        baos.close();
        inputStream.close();



        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server()throws  IOException{
        ServerSocket serverSocket = new ServerSocket(8889);
        Socket accept = serverSocket.accept();
        FileOutputStream fos = new FileOutputStream(new File("src/main/java/socketDemo/4.txt"));
        InputStream inputStream = accept.getInputStream();

        byte [] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("收到"+accept.getInetAddress().getHostAddress());

        //服务器给客户端的反馈
        OutputStream os = accept.getOutputStream();
        os.write("你好,我已收到文件".getBytes());

        os.close();

        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
