package Web_Apart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import JDBC_Apart.Dao.I_pageDao;
import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.PageResult;
import JDBC_Apart.Impl.MouseImpl;
import JDBC_Apart.Impl.Mouse_Dir_Impl;
import JDBC_Apart.Impl.PageDao_Impl;
import JDBC_Apart.Util.MouseQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

@WebServlet("/page")
public class pageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private I_pageDao dao;
	private Mouse_Dir_Impl dirDao;
	private Integer currentPage = 1;// 用户传入的当前页，如无则是按缺省1设置
	private Integer uPageSize = 3;// 用户传入的每页条数,如无则是按缺省3设置

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new PageDao_Impl();
		dirDao = new Mouse_Dir_Impl();

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("html/text;charset=utf8");
		if (req.getSession().getAttribute("dirs") == null) {
			req.getSession().setAttribute("dirs", dirDao.list());
		}
		String currentPage_User = req.getParameter("currentPage");
		if (StringUtils.isNoneBlank(currentPage_User)) {
			currentPage = Integer.valueOf(currentPage_User);
		}

		String PageSize = req.getParameter("User_pageSize");
		if (StringUtils.isNoneBlank(PageSize)) {
			uPageSize = Integer.valueOf(PageSize);
		}

		//System.out.println(currentPage);
		//System.out.println(uPageSize);
		List<Object> result = dao.query(currentPage, uPageSize);
		PageResult page = (PageResult) result.get(0);
		List<Mouse> m = (List<Mouse>) result.get(1);
		req.setAttribute("pageResult", page);
		req.setAttribute("Mouse",m);
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}

}
