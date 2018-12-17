package pub.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class CodeFilter implements Filter {
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) 
			throws ServletException, IOException {
//				System.out.println("我是第一个过滤器！可以解决Servlet中文乱码");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				chain.doFilter(request,response); //访问下一个filter类，执行完所有的filter再去执行页面。
	}
	public void init(FilterConfig config) {   }
	public void destroy() {}
}