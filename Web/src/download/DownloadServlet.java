package download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //获取ServletContext对象
        ServletContext sc=this.getServletContext();
        //找到文件服务器路径
        String realPath=sc.getRealPath("/img/"+filename);
        //用字节流关联
        FileInputStream fis=new FileInputStream(realPath);
        //3.设置response响应头
        //设置响应头类型：content-type
        String mimeType=sc.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.写入输出流
        ServletOutputStream sos=response.getOutputStream();
        byte[] buff=new byte[1024 * 8];
        int len=0;
        while ((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        };
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
