package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器已启动");
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket=serverSocket.accept();
        InputStream is=socket.getInputStream();
        byte[]bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os=socket.getOutputStream();
        os.write("服务器：收到".getBytes());
        serverSocket.close();
        socket.close();

    }

}
