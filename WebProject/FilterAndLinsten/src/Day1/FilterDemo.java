package Day1;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements javax.servlet.Filter {
	// ��ʼ��������
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��ʼ��������1");

	}

	// ִ�й���������
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		// System.out.println("ִ�й���������1");
		chain.doFilter(req, resp);// ���в���
	}

	// ���ٹ�����
	public void destroy() {
		System.out.println("���ٹ�����1");
	}

}
