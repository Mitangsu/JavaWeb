package com.atguigu.fruit.serlets;

import com.atguigu.fruit.dao.base.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-15 14:37
 */
@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet{
    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)){
            operate = "index";
        }

        switch (operate){
            case "index":
                index(request,response);
                break;
            case "add":
                add(request,response);
                break;
            case "del":
                del(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "update":
                update(request,response);
                break;
            default:
                throw new RuntimeException("operate值非法！");

        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取参数
        String fidStr =request.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr= request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        //3.执行更新
        fruitDAO.updateFruit(new Fruit(fid,fname,price,fcount,remark));

        //4.资源跳转
        //super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response)
        //此处需要重定向,目的是重新给IndexServlet发请求,重新获取furitList,然后覆盖到session中,这样index.html页面上显示的session中的数据才是最新的
        response.sendRedirect("fruit.do");


    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);

        }
    }

    private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);

            resp.sendRedirect("fruit.do");
        }
    }
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.
        request.setCharacterEncoding("utf-8");

        //2.
        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0, fname, price, fcount, remark);

        fruitDAO.addFruit(fruit);

        response.sendRedirect("fruit.do");

    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        //设置当前页默认值为1
        Integer pageNo = 1;


        String oper = req.getParameter("oper");
        //如果oper!=null 说明 通过表单的查询按钮点击过来的
        //如果oper是空的 说明 不是通过表单的查询按钮点击过来的

        String keyword = null;
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)){
            //说明是点击表单查询发送过来的请求
            //此时,pageNo应该还原1,keyword应该从请求参数中获取
            pageNo = 1;
            keyword = req.getParameter("keyword");
            //如果keyword为null,需要设置为空字符串"",否则查询会拼接成%null%,我们期望的是%%
            if (StringUtil.isEmpty(keyword)){
                keyword="";
            }
            //将keyword保存(覆盖)到session中
            session.setAttribute("keyword",keyword);
        }else{
            //说明此处不是点击表单查询发送过来的请求(比如点击下面的上一页下一页或者直接在地址值输入网址)
            //此时keyword应该从session作用域获取
            String pageNoStr = req.getParameter("pageNo");

            if (StringUtil.isNotEmpty(pageNoStr)){

                pageNo = Integer.parseInt(pageNoStr);//如果从请求中读取到pageNo,则类型转换.否则,pageNo默认为1

            }
            //如果不睡点击的查询按钮.那么查询是基于session中保存的现有的keyword进行的查询
            Object keywordObj = session.getAttribute("keyword");

            if (keywordObj != null){
                keyword =(String)keywordObj;
            }else{
                keyword = "";
            }

        }

        //重新更新当前页的值
        session.setAttribute("pageNo",pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNo);

        //保存到session作用域
//      HttpSession session = req.getSession();
        session.setAttribute("fruitList",fruitList);

        //总记录条数
        int fruitCount = fruitDAO.getFruitCount(keyword);
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
