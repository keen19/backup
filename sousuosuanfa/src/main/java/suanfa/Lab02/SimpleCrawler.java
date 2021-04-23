package suanfa.Lab02;



import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCrawler {
    List<String> findUrls=new ArrayList<>();
    List<String> pendUrls = new ArrayList<>();

    Hashtable<String,Integer> deepUrls=new Hashtable<>();

    String HomePage;
    int webDepth=10;

    public static void main(String[] args) {
        SimpleCrawler nb=new SimpleCrawler();
        nb.HomePage = "https://www.sise.com.cn/";
        nb.startHmpg();
    }
    public synchronized String getAUrl(){
        String tempAurl =pendUrls.get(0);
        pendUrls.remove(0);
        return tempAurl;
    }
    public void startHmpg(){
        findUrls.add(HomePage);
        pendUrls.add(HomePage);
        deepUrls.put(HomePage, 1);
        System.out.println("Start!");
        String tmp=getAUrl();
        URL url=null;
        try {
            url =new URL(tmp);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        this.findUrlFormHtml(url);

        for (int i = 0; i < 10; i++) {
            new Thread(new Processer(this)).start();
        }
    }

    public void findUrlFormHtml(URL url) {
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        BufferedReader br = null;
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.0)");
            conn.setDoInput(true);
            br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                Matcher m = p.matcher(line);
                if (deepUrls.get(url.toString()) < webDepth) {
                    while (m.find()) {
                        if (!findUrls.contains(m.group())) {
                            System.out.println(m.group());
                            findUrls.add(m.group());
                            pendUrls.add(m.group());
                            deepUrls.put(m.group(0),
                                    (deepUrls.get(url.toString()) + 1));

                        }
                    }
                }
            }
            System.out.println("抓取到页面" + url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class  Processer implements Runnable {
        SimpleCrawler nb;
        String s;
        public Processer(SimpleCrawler nb){this.nb=nb;}
        public Processer(SimpleCrawler nb,String s){
            this.nb=nb;
            this.s=s;
        }

        @Override
        public void run() {
            while (!pendUrls.isEmpty()){
                try {
                    String tmp=getAUrl();
                    URL url=null;
                    url=new URL(tmp);
                    nb.findUrlFormHtml(url);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    }

