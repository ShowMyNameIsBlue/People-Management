package com.xiaogang.sm.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        String path = req.getServletPath();
        if (path.toLowerCase().indexOf("login")!=-1){
            filterChain.doFilter(req,resp);
        }else {
            if (req.getSession().getAttribute("STA")!=null){
                filterChain.doFilter(req,resp);
            }else {
                resp.sendRedirect(req.getContextPath()+"/toLogin.do");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
