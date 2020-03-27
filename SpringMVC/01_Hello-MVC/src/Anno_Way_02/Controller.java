package Anno_Way_02;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping("/hello2")//
	public ModelAndView sayHello() {
		System.out.println("hello,i coming by anno....");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		mv.addObject("msg", "使用注解方式开发SpringMVC");
		return mv;
	}

}
