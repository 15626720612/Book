package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/servlet/user/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String userInput=request.getParameter("code");
		
		HttpSession session=request.getSession();
		char[] code=(char[])session.getAttribute("authCode");
		String rightCode =new String(code);
		System.out.println("用户输入的验证码:"+userInput
				+" 生成的验证码是:"+rightCode);
		response.setCharacterEncoding("utf-8");
		
		User user = new User();
		user.setSid(id);
		user.setPassword(password);
		
		UserService service = new UserService();
		Map<String,Object> map = service.login(user);
		
		boolean f = (Boolean) map.get("f");
		User loginUser = (User)map.get("user");
		
		
		if(f&&userInput.equals(rightCode)){
			//记录一个用户已经登录的标志
			session.setAttribute("logined", id);
			response.getWriter().write(loginUser.getName()+"succeed!");
			session.setAttribute("loginUser", loginUser);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/exam/sign.jsp");
//			rd.forward(request,response);
			
			response.sendRedirect("/Book/book/index.jsp");
		}else{
			response.getWriter().write("fail!");
		}
	}

}
