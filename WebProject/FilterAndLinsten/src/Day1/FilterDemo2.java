package Day1;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo2 implements javax.servlet.Filter {
	// ��ʼ��������
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��ʼ��������2");

	}

	// ִ�й���������
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ִ�й���������2");
		chain.doFilter(req, resp);// ���в���
	}

	// ���ٹ�����
	public void destroy() {
		System.out.println("���ٹ�����2");
	}

}
