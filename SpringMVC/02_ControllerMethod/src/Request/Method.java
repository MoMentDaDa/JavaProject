package Request;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Domian.FormBean;
import Domian.User;

@Controller
@RequestMapping("/request") // 模拟请求中的API使用
public class Method {
	@Autowired
	private ServletContext servletContexct;

	@RequestMapping("/test1")
	public void test1(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println(request.getParameter("username"));
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		System.out.println(this.servletContexct);
	}

	// 获取请求参数,保证请求参数名称和 Controller 方法的形式参数(入参)同名
	// 如果请求参数名称和形参名称不同--->应使用 RequestParam 进行获取
	@RequestMapping("/test2")
	public void test2(@RequestParam("name") String username, @RequestParam(value = "age", required = false) Integer age) {
		System.out.println("username" + username);
		System.out.println("age" + age);
	}

	// RESTfull风格传参，eg:delete?id=110 delete/110
	// @PathVariable:可以将URL中占位符绑定到方法的形参中
	@RequestMapping("/delete/{id}")
	public void test3(@PathVariable("id") Long id) {
		System.out.println(id);
	}

	// 接受一个参数有多个值的情况
	// 批量删除可以使用数组直接接收。batchDelete1?ids=10&ids=20&ids=30
	@RequestMapping("/batchDelete1")
	public void batchDelete(Long[] ids) {
		System.out.println(Arrays.toString(ids));
	}

	// 使用List:不能直接接收,可以在对象中存在一个集合，即把数据封装到对象中传递 eg:?ids[0]=10&ids[1]=20&ids[2]=30
	// 注意：在Tomcat7以上就已经添加了RFC 3986这个规范。不能使用{和]字符传递，所以会报错。可以使用前端请求对URL编码或者修改Get方法为Post方法解决
	@RequestMapping("/batchDelete2")
	public void batchDelete(FormBean fb) {
		System.out.println(fb.getIds());
	}

	// 把数据直接封装到JavaBean对象
	@RequestMapping("/test4")
	public void test4(User u) {
		System.out.println(u);
	}

}
