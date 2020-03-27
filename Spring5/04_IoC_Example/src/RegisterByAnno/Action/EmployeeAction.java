package RegisterByAnno.Action;
//模拟springMVC 的Controller

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import Register.Domain.Employee;
import Register.Service.EmployeeServiceDao;

@Controller
public class EmployeeAction {
	@Autowired
	private EmployeeServiceDao serviceDao;

	public String execute() {
		System.out.println("注册请求来了。。。。。");
		serviceDao.register(new Employee());
		return "success";
	}
}
