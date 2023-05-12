// 
// 
// 

package com.depot.ex.admin.interceptor;

import com.depot.ex.admin.entity.User;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        final User user = (User)request.getSession().getAttribute("user");
        if (user != null) {
            response.sendRedirect("/depot-system/index/toindex");
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
