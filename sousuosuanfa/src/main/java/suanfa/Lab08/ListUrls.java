package suanfa.Lab08;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListUrls {
    public static void main(String[] args) throws IOException {
        UrlToTxt(new File("F:/课件/大三/移动WEB开发/实验3 移动WEB界面样式"));
    }

    public static void print(String msg,Object args){
        System.out.println(String.format(msg,args));
    }

    private static void UrlToTxt(File dir)throws IOException {
        BufferedWriter bw=null;
        for (File fs : dir.listFiles()) {
            if (fs.isDirectory()){
                UrlToTxt(fs);
            }else if (fs.getName().substring(fs.getName().lastIndexOf(".")).equals(".html")){
                bw=new BufferedWriter(new FileWriter(new File("F:/课件/大三/移动WEB开发/实验3 移动WEB界面样式/uri"+fs.getName()+
                        ".txt"),true));
                Document doc=Jsoup.parse(fs,"UTF-8");
                Elements links=doc.select("a[href]");
                for (Element link : links) {
                    bw.write(link.attr("abs:href"+"\n"));
                    print("%s",link.attr("abs:href"));
                }
                bw.close();
            }
        }
    }
}
