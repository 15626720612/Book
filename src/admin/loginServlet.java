package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 管理员登陆页面
 * */

public class loginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println(name);
		String pwd = request.getParameter("pwd");
		String userInput = request.getParameter("code");
		
		HttpSession session=request.getSession();
		char[] code=(char[])session.getAttribute("authCode");
		String rightCode =new String(code);
		System.out.println("用户输入的验证码:"+userInput
				+" 生成的验证码是:"+rightCode);
		response.setCharacterEncoding("utf-8");
		
		boolean f = name.equals("admin")&&pwd.equals("root");
		if(f&&userInput.equals(rightCode)){
			response.sendRedirect("/Book/admin/index.jsp");
		}else{
			Writer out = response.getWriter();
			out.write("登录失败！");
		}
	}

}
