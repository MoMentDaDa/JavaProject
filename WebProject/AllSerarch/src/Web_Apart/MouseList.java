package Web_Apart;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.mysql.fabric.xmlrpc.base.Value;

import JDBC_Apart.Dao.PageReslut_Dao;
import JDBC_Apart.Impl.MouseDir_Impl;
import JDBC_Apart.Impl.Mouse_Impl;
import JDBC_Apart.Impl.PageDao_Impl;
import JDBC_Apart.Object.Mouse;
import JDBC_Apart.Object.PageResult;
import JDBC_Apart.adancedQuery.ProductQueryObject;

@WebServlet("/mouse")
public class MouseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer currentPage = 1;// �û�����ĵ�ǰҳ���������ǰ�ȱʡ����
	private Integer uPageSize = 3;// �û������ÿҳ����,�������ǰ�ȱʡ����
	private PageReslut_Dao pageDao;
	private MouseDir_Impl dirDao;
	private Mouse_Impl dao;
	private ProductQueryObject go;

	// ��ʼ��dao����
	public void init() throws ServletException {
		pageDao = new PageDao_Impl();
		dirDao = new MouseDir_Impl();
		go = new ProductQueryObject();
		dao = new Mouse_Impl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("html/text;charset=utf8");
		// ����û��Ƿ��Ѿ���¼
		Object user = req.getSession().getAttribute("USER_IN_SEESSION");
		if (user == null) {
			req.setAttribute("errorMsg", "�ף������ȵ�¼");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			if (req.getSession().getAttribute("dirs") == null) {
				req.getSession().setAttribute("dirs", dirDao.list());
			}
			this.requestPacking(req, go); // ��װ��ѯ��������
			String currentPage_User = req.getParameter("currentPage");
			if (StringUtils.isNoneBlank(currentPage_User)) {
				currentPage = Integer.valueOf(currentPage_User);
			}

			String PageSize = req.getParameter("User_pageSize");
			if (StringUtils.isNoneBlank(PageSize)) {
				uPageSize = Integer.valueOf(PageSize);
			}
			PageResult page = pageDao.pageInfo(currentPage, uPageSize, go);
			List<Mouse> list = dao.page_advanced_Query(page, go);
			req.setAttribute("pageResult", page);
			req.setAttribute("Mouse", list);
			req.setAttribute("go", go);
			req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		}
	}

	public void requestPacking(HttpServletRequest req, ProductQueryObject go) throws ServletException, IOException {
		// ��ȡ�ύ���������ж��Ƿ��в���
		String name = req.getParameter("name");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		String dirId = req.getParameter("dirId");
		String keyword = req.getParameter("keyword");
		if (StringUtils.isNotBlank(req.getParameter("name"))) {
			go.setName(name);
		} else {
			go.setName(null);
		}

		if (StringUtils.isNotBlank(req.getParameter("minPrice"))) {
			go.setMinPrice(minPrice);
		} else {
			go.setMinPrice(null);
		}

		if (StringUtils.isNotBlank(req.getParameter("maxPrice"))) {
			go.setMaxPrice(maxPrice);
		} else {
			go.setMaxPrice(null);
		}

		if (StringUtils.isNotBlank(req.getParameter("dirId"))) {
			go.setDirId(Integer.valueOf(dirId));
		}

		if (StringUtils.isNotBlank(req.getParameter("keyword"))) {
			go.setKeyWord(keyword);
		} else {
			go.setKeyWord(null);
		}
	}

}
