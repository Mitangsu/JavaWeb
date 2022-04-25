package com.atguigu.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-03-11 20:46
 */
public class AddServlet extends HttpServlet {

    //收集post请求
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get方式目前不需要设置编码(基于tomcat8)

//      //如果是get请求发送的中文数据,转码稍微有点麻烦(tomcat8之前)
//      String fname = request.getParameter("fname");
//      //1.将字符串达打散成字节数组
//      byte[] bytes = fname.getBytes("ISO-8859-1");
//      //2.将字节数组按照设定的编码重新组装成字符串
//      fname= new String(bytes, "UTF-8");

        //post方式下，设置编码，防止中文乱码
        //需要注意的是,设置编码这一句代码必须在所有获取参数动作之前
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");

        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);

        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);

        String remark = request.getParameter("remark");

        System.out.println("fname =" +fname);
        System.out.println("price =" +price);
        System.out.println("fcount =" +fcount);
        System.out.println("remark =" +remark);

        FruitDAOImpl fruitDAO = new FruitDAOImpl();
        boolean flag = fruitDAO.addFruit(new Fruit(0,fname, price, fcount, remark));

        System.out.println(flag ? "添加成功":"添加失败");


    }
}










