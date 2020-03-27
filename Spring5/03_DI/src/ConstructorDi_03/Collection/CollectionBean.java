package ConstructorDi_03.Collection;

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

	public CollectionBean(Set<String> set, List<String> list, String[] array, Map<String, String> map,
			Properties prop) {
		super();
		this.set = set;
		this.list = list;
		this.array = array;
		this.map = map;
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "CollectionBean [\nset=" + set + "," + "\nlist=" + list + ", \narray=" + Arrays.toString(array)
				+ ", \nmap=" + map + ", \nprop=" + prop + "\n]";
	}

}
