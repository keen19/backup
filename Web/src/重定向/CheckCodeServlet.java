package 重定向;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //1.创建一个对象，在内存中图片
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
          //填充背景颜色
        Graphics g=image.getGraphics();//画笔对象
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);
          //画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);

        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
          //生成随机角标
        Random random = new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i < 5; i++) {
            int index=random.nextInt(str.length());
            //获取字符
            char ch=str.charAt(index);
            sb.append(ch);
            //写验证码
            g.drawString(ch+"",(width/5)*i,height/2);
        }
        String checkCode_session = sb.toString();
        //將驗證碼存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);
        //画干扰线
        g.setColor(Color.gray);
        //随机生成坐标点
        for (int i=0;i<10;i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);

            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);

        }
        //3.显示图片
        ImageIO.write(image,"jpg",response.getOutputStream());


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
