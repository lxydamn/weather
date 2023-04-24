package com.web.weather;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;

public class CityServlet extends HttpServlet {
    private String jsonStr;
    public void getJson() {
        // 读取areas json 文件
        try {
            File file = new File(getClass().getResource("/areas.json").toURI());

            FileReader fileReader = new FileReader(file,Charset.forName("UTF-8"));
            int ch;

            StringBuilder sb = new StringBuilder();

            while ((ch = fileReader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            jsonStr = sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        getJson();
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() throws ServletException {
    }
}
