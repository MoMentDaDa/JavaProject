package ByAnno.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import ByAnno.Util.UserContext;

//登录检查拦截器
public class CheckLoging implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 没有登录的情况
		if (UserContext.getCurrentUser() == null) {
			response.sendRedirect("/login.jsp");
			return false;// 阻止往后放行
		}
		return true;// 放行,放行给下一个拦截器或最终的处理器
	}
}
