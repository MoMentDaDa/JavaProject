package Day2;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * @ClassName: CharacterEncondingFilter
 * @Description: ר�������ַ����봦��
 * @author: ������
 * @date: 2019��6��16�� ����2:58:40
 */
public class LoginCheckFilter implements javax.servlet.Filter {
	private String encoding;
	private Boolean forceEnconding;
	// ����Ҫ������Դ
	private String[] unCheckUris = { "/login.jsp", "login" };

	// ��ʼ��������
	public void init(FilterConfig filterConfig) throws ServletException {
		// ��ȡXML������Ϣ
		this.encoding = filterConfig.getInitParameter("encoding");
		forceEnconding = Boolean.valueOf("force");

	}

	// ִ�й���������
	public void doFilter(ServletRequest reqest, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// �Ƚ�������ת��
		HttpServletRequest req = (HttpServletRequest) reqest;
		HttpServletResponse resp = (HttpServletResponse) response;
		// ��ȡ��������
		Object user = req.getSession().getAttribute("USER_IN_SESSION");
		// ���ñ���
		// 1��Ӧ����û�б��룬���Լ������˱���
		// 2��Ӧ�����ޱ��룬������Ȼʹ���Լ����õı��룬ǿ��ʹ��
		if (hasLength(encoding) && (req.getCharacterEncoding() == null || forceEnconding)) {
			req.setCharacterEncoding(encoding);
			// req.setCharacterEncoding("utf-8");
			// System.out.println("ִ�й���������1");

		} else if (user == null) {
			resp.sendRedirect("/login.jsp");
			return;
		}
		chain.doFilter(req, resp);// ���в���
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

	// ���ٹ�����
	public void destroy() {
		System.out.println("���ٹ�����1");
	}

}
