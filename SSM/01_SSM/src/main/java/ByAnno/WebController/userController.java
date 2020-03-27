package ByAnno.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ByAnno.Domain.User;
import ByAnno.Service.userServiceDao;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userServiceDao userService;

	// 列表查询 访问：localhost/user/list
	// 列表查询
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("users", userService.listAll());
		return "/user/list";
	}

	// 进入编辑界面
	@RequestMapping("/input")
	public String input(Long id, Model model) {
		if (id != null) {
			model.addAttribute("user", userService.get(id));
		}
		return "/user/input";
	}

	// 保存或更新操作
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(User user) {
		if (user.getId() == null) {
			userService.save(user);
		} else {
			userService.update(user);
		}
		return "redirect:/user/list";
	}

	// 删除操作
	@RequestMapping("/delete")
	public String delete(Long id) {
		if (id != null) {
			userService.delete(id);
		}
		return "redirect:/user/list";
	}
}
