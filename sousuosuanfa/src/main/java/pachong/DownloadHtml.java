package pachong;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URL;
import java.net.URLConnection;

public class DownloadHtml {
    public static void downloadHtmlByNet(String srcPath,String filePath,String fileName) throws Exception{
        URL url=new URL(srcPath);
        URLConnection conn = url.openConnection();
        //1.设置时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //2.放置屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 5.0;Windows NT;DigExt)");
        //3.输出流
        InputStream str=conn.getInputStream();
        //4.控制流的大小为1k
        byte[] bytes=new byte[1024];
        //5.读取到长度
        int len=0;
        //6.是否需要创建文件夹
        File saveDir=new File(fileName);
        if (!saveDir.exists()){
            saveDir.mkdir();
        }
        File file=new File(saveDir+File.separator+filePath);
        //实例输出一个对象
        FileOutputStream out=new FileOutputStream(file);
        //循环判断，如果读取的个数b为空了，则is.read()方法返回-1，具体请参考InputStream的read();
        while ((len=str.read(bytes,0,len))!=-1){
            //将对象写入到对应的文件中
            out.write(bytes, 0, len);
        }
        //刷新流
        out.flush();
        //关闭流
        out.close();
    }
}
