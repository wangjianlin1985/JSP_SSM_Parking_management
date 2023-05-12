// 
// 
// 

package com.depot.ex.admin.interceptor;

import java.io.PrintWriter;
import com.depot.ex.utils.Constants;
import com.depot.ex.admin.entity.User;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.UserService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter
{
    @Autowired
    private UserService userService;
    
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        final User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            final PrintWriter out = response.getWriter();
            final StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
            builder.append("alert(\"\u9875\u9762\u8fc7\u671f\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\");");
            builder.append("window.top.location.href=\"");
            builder.append(Constants.basePath);
            builder.append("/login/login\";</script>");
            out.print(builder.toString());
            out.close();
            return false;
        }
        final User user2 = this.userService.findUserById(user.getId());
        if (user2 == null) {
            request.getSession().removeAttribute("user");
            final PrintWriter out2 = response.getWriter();
            final StringBuilder builder2 = new StringBuilder();
            builder2.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
            builder2.append("alert(\"\u67e5\u65e0\u8be5\u7528\u6237\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\");");
            builder2.append("window.top.location.href=\"");
            builder2.append(Constants.basePath);
            builder2.append("/login/login\";</script>");
            out2.print(builder2.toString());
            out2.close();
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
