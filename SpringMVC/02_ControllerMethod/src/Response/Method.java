package Response;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Domian.User;

//处理响应
@RequestMapping("/responses")
@Controller
public class Method {
	// 返回void类型,此时可以把Controller方法当做Servlet来使用
	@RequestMapping("/test1")
	public void test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 请求转发:
		request.getRequestDispatcher("").forward(request, response);
		// URL重定向
		response.sendRedirect("");
		// 设置共享数据
		request.setAttribute("", "");
		// 输出JSON格式
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println("");
	}

	// 返回void:文件下载
	@RequestMapping("/test2")
	public void test2(OutputStream out) throws IOException {
		Files.copy(Paths.get("C:/Users/MoMent/Desktop/tmp.txt"), out);
	}

	// 返回ModelAndView
	@RequestMapping("/test3")
	public ModelAndView test3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "你好汪哒哒");// 设置共享数据的key和value
		mv.addObject("小汪同学");// 设置共享数据value,此时会把value类型的首字母作为key:string
		mv.setViewName("welcome");
		return mv;
	}
	/*
	 	前缀:/WEB-INF/views/
	 	后缀:.jsp
		物理视图= 前缀+逻辑视图名+后缀
		 <!-- 配置视图解析器 -->
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
		</bean>
	*/

	// 返回String,逻辑视图名称,此时需要结合Model类型的参数一起使用
	@RequestMapping("/test4")
	public String test4(Model model) {
		model.addAttribute("msg", "返回String");
		model.addAttribute("小汪17岁");
		return "welcome";
	}

	// 请求转发,浏览器地址栏不改变,可以共享请求中的数据
	// 原理:request.getRequestDispatcher("").forward(request, response);
	@RequestMapping("/test5")
	public String test5(Model model) {
		model.addAttribute("msg", "学妹加个微信呀");
		return "forward:/a.jsp";
	}

	// URL重定向,浏览器地址栏会改变,不能共享请求中的数据
	// 原理:response.sendRedirect("");
	@RequestMapping("/test6")
	public String test6(Model model) {
		model.addAttribute("不会共享数据");
		return "redirect:/a.jsp";
	}
	/*
	 请求资源的路径问题:：以后访问资源的时候,都使用/开头. 重定向 redirect:/hello.html 和 redirect:hello.html
	 访问资源的时候前面带上/,表示绝对路径，从根路径开始去寻找资源，访问资源的时候签名不加/，表示相对路径,从上一级上下文路径中去寻找资源.
	  
	  /response/test6----->"redirect:/hello.html";--->localhost:/hello.html
	  /response/test6----->"redirect:hello.html";--->localhost:/response/hello.html
	 
	 传统的方式,在URL重定向的时候,因为是两次不同的请求,所以不能共享请求中的数据. 在开发中有的时候,真的需要重定向跳转后共享数据.
	 spring3.1开始 提供了开始 提供了Flash属性.,只能使用从Controller重定向到Controller,不能到JSP.
	 */

	// 重定向共享数据方式，从a跳转到b
	@RequestMapping("/a")
	public String a(RedirectAttributes ra) {
		// ra.addAttribute("msg1", "这是传统模式。。");// 这是传统方式，将参数放到请求后面，明码传递
		ra.addFlashAttribute("msg2", "这是flash模式。。。");// 这是flash模式。隐式传递
		return "redirect:/responses/b";
	}

	@RequestMapping("/b")
	public ModelAndView b(String msg1, @ModelAttribute("msg2") String msg2) {
		// System.out.println("msg1:" + msg1);
		System.out.println("msg2:" + msg2);
		return null;
	}

	// 把单个对象/Map转换为JSON格式
	@RequestMapping("/save")
	@ResponseBody
	public User test4() {
		User u = new User();
		u.setUsername("will");
		u.setAge(17);
		return u;
	}
}
