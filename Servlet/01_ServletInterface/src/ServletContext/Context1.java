package ServletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: Communication
 * @Description: 演示通过ServletContext实现通讯
 * @author: MoMent
 * @date: 2020年3月1日 上午11:04:01
 */
@SuppressWarnings("all")
public class Context1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取一个打印输出流
		PrintWriter out = resp.getWriter();
		// 获取 context 对象
		ServletContext context = this.getServletContext();
		// 从 GenericServletConfig 获取数据,应该先访问GenericServletConfig的servlet,让它把数据存进去
		System.out.println(context.getAttribute("myValue"));
		System.out.println(context.getAttribute("myValue2"));
		context.removeAttribute("myValue2");
		System.out.println("myValue2已经移除" + context.getAttribute("myValue2"));
		// 获取整个站点的配置信息
		System.out.println("全站配置参数" + context.getInitParameter("webConfig"));
		// 获取web项目中的资源
		// 1、获取web项目下指定资源的路径 ：
		// 以前读取文件的时候，如果程序和文件在同一包名，可以直接通过文件名称获取得到的。因为以前我们写的程序都是通过JVM来运行的，但现在是通过Tomcat来运行的，所以再按下面方式会报500
		/*
		FileInputStream fileInputStream = new FileInputStream("1.png");
		System.out.println(fileInputStream);
		*/
		// 根据web的目录规范，Servlet编译后的class文件是存放在WEB-INF\classes文件夹中的，所以1.png是在该目录，所以按照以前的的方式读取，便会出现路劲不对找不到
		FileInputStream fileInputStream = new FileInputStream(
				"F:/JavaProject/Servlet/01_ServletInterface/WebRoot/WEB-INF/classes/ServletContext/1.png");
		System.out.println("绝对路径的方式，在包中:" + fileInputStream);
		// 但是通过上面方式读取，路劲写死了，那就不灵活，所以可以通过context解决,调用ServletContext方法获取到读取文件的流
		System.out.println("ServletContext方式,在包中：" + context.getResourceAsStream("/WEB-INF/classes/ServletContext/1.png"));
		// 如果文件放在web目录下，直接通过文件名称就能获取
		System.out.println("ServletContext方式，在web目录下：" + context.getResourceAsStream("1.png"));
		// 如果文件放在了src目录下,即类目录。先获取到类装载器，后通过类装载器获取到读取文件流。如果文件太大，就不能用类装载器的方式去读取，会导致内存溢出
		ClassLoader classLoader = Context1.class.getClassLoader();
		System.out.println("文件在类目录：" + classLoader.getResourceAsStream("1.png"));
		// 输出文件的真实路径
		System.out.println(context.getRealPath("1.png"));
		System.out.println("contextPath:" + context.getContextPath());
		System.out.println(System.getProperty("user.dir"));
		// 获取指定路径下的所有内容。
		Set set = context.getResourcePaths("/WEB-INF");
		Iterator iterator = set.iterator();
		System.out.println("WEB-INF文件下的所有文件：");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}

	}

}
