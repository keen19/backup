package socketDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ScoketDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.126", 8889);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是客户端".getBytes());
        outputStream.close();;
        socket.close();

    }
}
