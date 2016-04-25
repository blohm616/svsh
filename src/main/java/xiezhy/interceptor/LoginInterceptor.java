package xiezhy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * version:
 * --------------------
 * date:2016/4/25
 * author:binbin
 */
public class LoginInterceptor implements HandlerInterceptor{
    /**
     * 进入handler之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return 身份验证
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println(httpServletRequest.getRequestURL());

        System.out.println("LoginInterceptor: preHandle" );

        return true;
    }

    /**
     * 进入handler之后，返回modelAndView之前
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     * 将公用的模型数据（菜单导航）传到视图，也可以统一指定视图
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {


        System.out.println("LoginInterceptor: postHandle" );

        System.out.println(modelAndView.getViewName());

    }

    /**
     * 执行handler后
     * 统一异常处理，统一日志处理
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

        System.out.println("LoginInterceptor: afterCompletion" );

    }
}
