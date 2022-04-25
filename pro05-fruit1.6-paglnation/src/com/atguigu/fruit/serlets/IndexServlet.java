package com.atguigu.fruit.serlets;

import com.atguigu.fruit.dao.base.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.util.StringUtil;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-13 16:53
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pageNo = 1;

        String pageNoStr = req.getParameter("pageNo");

        if (StringUtil.isNotEmpty(pageNoStr)){

            pageNo = Integer.parseInt(pageNoStr);

        }

        HttpSession session = req.getSession();
        session.setAttribute("pageNo",pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);

        //保存到session作用域
//      HttpSession session = req.getSession();
        session.setAttribute("fruitList",fruitList);

        //总记录条数
        int fruitCount = fruitDAO.getFruitCount();
        //总页数
        int pageCount = (fruitCount + 5 - 1) / 5;

        session.setAttribute("pageCount",pageCount);


        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 : index
        //物理视图名称 : view-prefix + 逻辑视图名称 + view-suffix
        //所以 真实的视图名称是： /       index           html
        super.processTemplate("index",req,resp);


    }
}


























