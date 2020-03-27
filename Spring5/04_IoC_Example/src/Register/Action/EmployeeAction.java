package Register.Action;
//模拟springMVC 的Controller

import Register.Domain.Employee;
import Register.Service.EmployeeServiceDao;
import lombok.Setter;

public class EmployeeAction {
	@Setter
	private EmployeeServiceDao serviceDao;

	public String execute() {
		System.out.println("注册请求来了。。。。。");
		serviceDao.register(new Employee());
		return "success";
	}
}
