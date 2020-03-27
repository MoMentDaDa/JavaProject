package LogUtil.Log;

import java.util.Date;

//模拟事务管理器:
public class LogUtil {
	public void writeLog(String className, String methodName) {
		System.out.println(new Date().toLocaleString() + "调用了" + className + "类中的" + methodName + "方法");
	}
}
