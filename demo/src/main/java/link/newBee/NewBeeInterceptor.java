package link.newBee;

/**
 * data 2018-06-27   23:11
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
import link.newBee.Entity.User;
import link.newBee.annocation.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Configuration
public class NewBeeInterceptor implements HandlerInterceptor{
    Logger logger = LoggerFactory.getLogger(NewBeeInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handler2 = (HandlerMethod) handler;
            Log annotation = handler2.getMethodAnnotation(Log.class);
            if (annotation != null) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("loginUser");
                String name = user != null ? "[" + user.getUserName() + "]" : "";
                logger.info(name + "[" + annotation.value() + "][" + handler2.getMethod().getDeclaringClass().getName() + "." + handler2.getMethod().getName() + "][" + request.getRemoteAddr() + "]");
            }
        }
        logger.info("preHandle1");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle1");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion1");
    }





}