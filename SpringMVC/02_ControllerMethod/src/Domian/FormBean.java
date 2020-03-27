package Domian;

import java.util.ArrayList;
import java.util.List;
//用于封装表单提交的数据的对象
public class FormBean {
private List<Long> ids = new ArrayList<>();
	
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
	public List<Long> getIds() {
		return ids;
	}
}
