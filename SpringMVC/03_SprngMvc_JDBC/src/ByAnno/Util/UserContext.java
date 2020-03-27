package ByAnno.Util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ByAnno.domain.Employee;

//封装当前登录用户的上下文信息，利用RequestContextHolder 更加方便的设置用户信息
public class UserContext {
	private static final String USER_IN_SESSION = "user_in_session";

	// 获取HttpSession对象
	public static HttpSession getSession() {
		// 进行强转为子类，以获取session
		return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	}

	public static void setCurrentUser(Employee current) {
		if (current == null) {
			getSession().invalidate();
		} else {
			getSession().setAttribute(USER_IN_SESSION, current);
		}
	}

	public static Employee getCurrentUser() {
		return (Employee) getSession().getAttribute(USER_IN_SESSION);
	}
}
