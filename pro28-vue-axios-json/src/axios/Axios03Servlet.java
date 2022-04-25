package axios;

import com.google.gson.Gson;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-03-28 18:34
 */
@WebServlet("/axios03.do")
public class Axios03Servlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer("");
        BufferedReader reader = req.getReader();
        String str =null;
        while ((str=reader.readLine())!= null){
                stringBuffer.append(str);
        }
        str=stringBuffer.toString();
        //已知String
        //需要转换成JavaObject

        Gson gson = new Gson();
        //Gson有两个API
        //1.fromJson(string,T)将字符串转换成java object
        //2.toJson(java object)将java object转换成json字符串

        User user = gson.fromJson(str, User.class);
        user.setNumae("小智");
        user.setPwd("120074111");

       //假设user是数据库查询出来的,现在需要将其转换成json格式的字符串,然后响应给客户端
        String userJsonStr = gson.toJson(user);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(userJsonStr);


    }
}
