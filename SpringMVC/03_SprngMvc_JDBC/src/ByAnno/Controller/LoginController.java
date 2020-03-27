package ByAnno.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ByAnno.service.IEmployeeService;

@Controller
public class LoginController {

	@Autowired
	private IEmployeeService employeeService;

	// 利用RequestContextHolder 设置session信息
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		try {
			employeeService.login(username, password);
		} catch (Exception e) {
			session.setAttribute("errorMsg", e.getMessage());// 从抛出的异常中获取异常信息
			return "redirect:/login.jsp";
		}
		return "redirect:/employee/list";
	}
}
