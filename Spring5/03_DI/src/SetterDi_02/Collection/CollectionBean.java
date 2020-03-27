package SetterDi_02.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
//需求：演示注入集合类型
public class CollectionBean {
	private Set<String> set;
	private List<String> list;
	private String[] array;
	private Map<String, String> map;
	private Properties prop;

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "CollectionBean [\nset=" + set + ","+"\nlist=" + list + ", \narray=" + Arrays.toString(array) + ", \nmap=" + map
				+ ", \nprop=" + prop + "\n]";
	}

}
