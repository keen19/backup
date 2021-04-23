package pachong;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpClientUtils {
    private static DefaultHttpClient httpClient=new DefaultHttpClient();

    public static boolean downloadPage(String url,String path) throws Exception{
        //1.定义输入输出流
        InputStream input=null;
        OutputStream outputStream=null;
        //得到Get方法
        HttpGet getMethod=new HttpGet(url);
        HttpResponse response=httpClient.execute(getMethod);
        input=response.getEntity().getContent();
        String fileName = url.substring(url.lastIndexOf('/') + 1) + ".html";
        outputStream=new FileOutputStream(path+"/"+fileName);
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=input.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        input.close();;
        outputStream.close();
        System.out.println("下载成功");
        return true;
    }

    public static void main(String[] args) throws Exception {
        new HttpClientUtils().downloadPage("https://www.sise.com.cn/","F://111");
    }
}
