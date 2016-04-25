package xiezhy.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * version:
 * --------------------
 * date:2016/4/25
 * author:binbin
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        CustomException ce = null;
        if(e instanceof CustomException)
            ce = (CustomException) e;
        else
            ce = new CustomException("未知异常!!!");

        String msg = ce.getMsg();

        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","msg");
        mav.setViewName("error");

        return mav;
    }
}
