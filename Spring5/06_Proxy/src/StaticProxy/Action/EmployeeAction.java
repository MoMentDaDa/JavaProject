package StaticProxy.Action;
//模拟springMVC 的Controller

import StaticProxy.Service.EmployeeServiceDao;
import lombok.Setter;

public class EmployeeAction {
	@Setter
	private EmployeeServiceDao serviceDao;

	public String execute() {
		System.out.println("注册请求来了。。。。。");
		return "success";
	}
}
