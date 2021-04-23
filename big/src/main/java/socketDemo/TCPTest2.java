package socketDemo;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {

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
        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server()throws  IOException{
        ServerSocket serverSocket = new ServerSocket(8889);
        Socket accept = serverSocket.accept();
        FileOutputStream fos = new FileOutputStream(new File("src/main/java/socketDemo/3.txt"));
        InputStream inputStream = accept.getInputStream();

        byte [] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("收到"+accept.getInetAddress().getHostAddress());
        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
