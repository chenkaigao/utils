package com.kico.test;

import com.kico.domain.UserTest;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/BeanUtilsServlet")
public class BeanUtilsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*通用的解决乱码方式
        String name = req.getParameter("name");
        System.out.println(name);
        byte[] bytes = name.getBytes("ISO8859-1");
        String s = new String(bytes, "UTF-8");
        System.out.println(s);*/

        //现在使用的方法可以设置请求时使用的编码   只适用post提交方式     get方式使用无效
        //form表单以后都是post方式提交
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> allP = req.getParameterMap();
        for (Map.Entry<String,String[]> entry: allP.entrySet()) {
            System.out.println(entry.getKey()+" = "+ Arrays.toString(entry.getValue()));
        }
        System.out.println("------------------------");
        UserTest u = new UserTest();
        try {
            org.apache.commons.beanutils.BeanUtils.populate(u,allP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(u);
    }
}
