package Other;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DateUtils {
	// 如果不想每次都在Date类型上贴 @DateTimeFormat，可以使用@InitBinder实现参数绑定
	@InitBinder
	public void initBinderDateType(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}
