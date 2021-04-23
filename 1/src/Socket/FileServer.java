package Socket;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动");
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        InputStream is = socket.getInputStream();
                        File file = new File("e:\\aa");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        FileOutputStream fos = new FileOutputStream(file + "\\2.txt");
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        socket.getOutputStream().write("上传成功".getBytes());
                        fos.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

            }).start();
        }
    }
}


//        socket.close();


