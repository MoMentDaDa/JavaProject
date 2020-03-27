package XML_Way_01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class Controller implements org.springframework.web.servlet.mvc.Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("hello,i coming....");
		ModelAndView mv = new ModelAndView();
		//设置视图名称
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		//设置共享数据
		mv.addObject("msg", "你好SpringMVC");
		return mv;
	}

}
