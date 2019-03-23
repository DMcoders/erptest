package com.example.erp01.config.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hujian on 2019/3/23
 */

@Component
public class UrlInterceptor  implements HandlerInterceptor {

    public UrlInterceptor(){super();}

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)  {
        if(request.getSession().getAttribute("basePath")==null){
            String path=request.getContextPath();
            String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            request.getSession().setAttribute("basePath", basePath);
        }
        return true;
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
