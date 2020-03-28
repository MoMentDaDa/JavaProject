package Request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//操作其他请求头中的其他信息
@Controller
@RequestMapping("/other")
@SessionAttributes("errorMsg")
public class Other {
	@RequestMapping("/test1")
	private void test1(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Host") String host,
			@CookieValue("JSESSIONID") String cName) {
		System.out.println("test1 is coming....");
		System.out.println(userAgent);
		System.out.println(host);
		System.out.println(cName);
	}

	// 操作HttpSession,默认重定向是不能实现数据共享的，因为那是两次请求
	// 默认情况下Model数据是放到request中共享的,如果我想在session共享---->贴上SessionAttributes即可实现数据在重定向中共享
	@RequestMapping("/test2")
	public String test2(Model model) {
		System.out.println("test2 is coming.....");
		model.addAttribute("errorMsg", "错误信息");
		return "redirect:/a.jsp";
	}

}