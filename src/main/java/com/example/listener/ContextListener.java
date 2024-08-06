package com.example.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LocalDateTime localDateTime = LocalDateTime.now();
        sce.getServletContext().setAttribute("servletTimeInit",localDateTime );
    }

}
