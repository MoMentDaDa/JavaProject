package Web_Apart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Impl.MouseImpl;
import JDBC_Apart.Impl.Mouse_Dir_Impl;
import JDBC_Apart.Util.MouseQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

@WebServlet("/mouse")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static private MouseImpl dao;
	private ProductQueryObject go;
	private Mouse_Dir_Impl dirDao;

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new MouseImpl();
		go = new ProductQueryObject();
		dirDao = new Mouse_Dir_Impl();

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("html/text;charset=utf8");
		if (req.getSession().getAttribute("dirs") == null) {
			req.getSession().setAttribute("dirs", dirDao.list());
		}
		
		
		this.requestPacking(req, go); // 封装查询参数对象
		List<Mouse> mouses = dao.advancedSearch(go);
		req.setAttribute("mouses", mouses);
		req.setAttribute("go", go);
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}

	public void requestPacking(HttpServletRequest req, ProductQueryObject go) throws ServletException, IOException {
		// 获取提交参数，并判断是否有参数
		String name = req.getParameter("name");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		String dirId = req.getParameter("dirId");
		String keyword = req.getParameter("keyword");
		if (StringUtils.isNotBlank(req.getParameter("name"))) {
			go.setName(name);
		}else{
			go.setName(null);
		}
		
		if (StringUtils.isNotBlank(req.getParameter("minPrice"))) {
			go.setMinPrice(minPrice);
		}else{
			go.setMinPrice(null);
		}
		
		if (StringUtils.isNotBlank(req.getParameter("maxPrice"))) {
			go.setMaxPrice(maxPrice);
		}else {
			go.setMaxPrice(null);
		}

		if (StringUtils.isNotBlank(req.getParameter("dirId"))) {
			go.setDirId(Integer.valueOf(dirId));
		}
		
		if (StringUtils.isNotBlank(req.getParameter("keyword"))) {
			go.setKeyWord(keyword);
		}else{
			go.setKeyWord(null);
		}

	}

}
