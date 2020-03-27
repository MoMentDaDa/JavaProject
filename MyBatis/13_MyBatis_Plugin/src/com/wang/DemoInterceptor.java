package com.wang;

import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

//需求：在对象中还是习惯使用驼峰表示法,不喜欢使用下划线风格的编程.期望Map中的key的下划线去掉,使用驼峰表示法。{uName=Stef, uId=1, uSn=abc}

//对 handleResultSets 组件中的handleResultSets 方法做增强
@Intercepts(@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class}))

public class DemoInterceptor implements Interceptor {
	private Properties properties;
	// 如何做增强
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		List<Object> ret = (List<Object>) invocation.proceed();// 底层返回的结果集,一个
		// 取出结果集中的每一个对象，对象使用 map 存储字段和值
		for (Object obj : ret) {
			// 判断是否为 Map 的实例
			if (!(obj instanceof Map)) {
				break;
			}
			// 是，调用方法处理
			handleMap((Map<String, Object>) obj);
		}
		return ret;// 放行

	}

	// 包装
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	// 给拦截器设置配置参数，配置可以由使用拦截器的人来给定
	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
		System.out.println(properties);
	}

	// 处理 Key 值
	private void handleMap(Map<String, Object> map) {
		// 复制 key 值，避免引发并发修改异常
		Set<String> keySet = new HashSet<>(map.keySet());
		// System.out.println(keySet);//[u_name, u_id, userType]
		for (String key : keySet) {
			// 判断key 是否大写字母开头或者带有下划线
			if (key.startsWith("A") && key.endsWith("Z") || key.contains("_")) {
				Object value = map.get(key);// 获取值
				map.remove(key);// 移除符合条件的 key 和值
				String newKey = handleKey(key);// 调用方法处理
				map.put(newKey, value);// 重新插入新的 key和值，uName 老师1
			}
		}
	}

	private String handleKey(String key) {
		StringBuffer sb = new StringBuffer(50);
		boolean findUnderLine = false;// 是否找到下划线
		// 循环迭代每个字母并判断和处理
		for (int index = 0; index < key.length(); index++) {
			char ch = key.charAt(index);// 获取每个字母
			if (ch == '_') {
				findUnderLine = true;// 找到
			} else {
				if (findUnderLine) {
					sb.append(Character.toUpperCase(ch));// 把下划线后面的第一个字母转为大写
					findUnderLine = false;
				} else {
					sb.append(Character.toLowerCase(ch));
				}
			}
		}
		return sb.toString();
	}
}
