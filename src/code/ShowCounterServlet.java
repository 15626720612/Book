package code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**显示资源访问次数的servlet*/
public class ShowCounterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		getInitParameter();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		/*----------显示ServletContext中的统计值----------------------*/
		ServletContext ctx = getServletContext();
		Map<String, Integer> counter
	  =(Map<String, Integer>) ctx.getAttribute("counter");
		Set<String> keys=counter.keySet();
		out.println("ServletContext中的统计数据是:<br>");
		for(String k:keys){
			out.println(k+":"+counter.get(k)+"次<br>");
		}
		/*----------显示HttpSession中的统计值-------------------------*/
		HttpSession session=request.getSession();
		counter=(Map<String,Integer>)session.getAttribute("counter");
		keys=counter.keySet();
		out.println("<br>HttpSession中的统计数据是:<br>");
		for(String k:keys){
			out.println(k+":"+counter.get(k)+"次<br>");
		}
		/*-------------------------------------------------------*/
		out.println(getInitParameter("encoding")+"<br>");//<servlet><init-param>
		out.println(ctx.getInitParameter("encoding"));//<context-param>
		out.println("  </BODY>");
		out.println("</HTML>");
		System.out.println(ctx.getRealPath(""));
		out.flush();
		out.close();
	}

}
