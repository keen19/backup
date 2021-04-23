package suanfa.Lab02;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstCrawler {
    public static void main(String[] args) {


    URL url=null;
    URLConnection urlconn=null;
    BufferedReader br=null;
    PrintWriter pw=null;
    String regex="https://[\\w+\\.?/?]+\\.[A-Za-z]+";
    Pattern p=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
    try{
        url=new URL("https://www.sise.com.cn/");
        urlconn=url.openConnection();
        pw=new PrintWriter(new FileWriter("F:/111/TEST.txt"),true);
        br=new BufferedReader(new InputStreamReader(
                urlconn.getInputStream()
        ));
        String buf=null;
        while ((buf=br.readLine())!=null){
            Matcher buf_m=p.matcher(buf);
            while (buf_m.find()){
                pw.println(buf_m.group());
            }
        }
        System.out.println("获取url成功");

    }catch(MalformedURLException e){
        e.printStackTrace();
    }catch(IOException exception){
        exception.printStackTrace();
    }finally{
        try {
            br.close();
        }catch (IOException e1){
            e1.printStackTrace();
        }
        pw.close();
    }
}
}

