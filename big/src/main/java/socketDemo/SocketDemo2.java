package socketDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8889);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        //不建议这样写,可能会有乱码
        /*byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            String s = new String(bytes, 0, len);

            System.out.println(s);
        }*/

        ByteArrayOutputStream bao =new ByteArrayOutputStream();
        byte[] bytes = new byte[5];
        int length;
        while ((length = inputStream.read(bytes))!=-1){
            bao.write(bytes,0,length);
        }
        System.out.println(bao.toString());

        bao.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
