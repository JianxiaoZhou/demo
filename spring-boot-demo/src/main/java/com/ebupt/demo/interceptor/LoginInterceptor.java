package com.ebupt.demo.interceptor;

import com.ebupt.demo.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{"index",};

        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath + "/");
        String page = uri;

        if (begingWith(page,requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if (user == null){
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean begingWith(String page, String[] requireAuthPages){
        boolean result = false;
        for (String requireAuthPage: requireAuthPages) {
            if (StringUtils.startsWith(page,requireAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }
}
