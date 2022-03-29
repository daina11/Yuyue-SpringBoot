package com.bs.yuyue.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag;

        //放行静态资源
        if (handler instanceof ResourceHttpRequestHandler)
            return true;
        //验证token信息是否正确

        //User user = (User) request.getSession().getAttribute("user");
        String token = request.getHeader("token");
//        if (user == null) {
//            System.out.println("拦截成功！！");
//            //验证不成功重定向到登录页
//            response.sendRedirect("/login");
//            flag = false;
//        } else {
//            flag = true;
//        }
        if(token==null){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JSONObject res = new JSONObject();
            res.put("code","502");
            res.put("message","token为空！");
            PrintWriter out = null ;
            out = response.getWriter();
            out.write(res.toString());
            out.flush();
            out.close();
            return false;
        }else {
            try {
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("daina");
                Jws<Claims> ClaimsJws =parser.parseClaimsJws(token);
                return  true;
            }catch (Exception e){
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                JSONObject res = new JSONObject();
                res.put("code","505");
                res.put("message","登录验证失败！");
                PrintWriter out = null ;
                out = response.getWriter();
                out.write(res.toString());
                out.flush();
                out.close();
                return false;
            }

        }

    }

}
