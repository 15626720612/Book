package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/user/register")
public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String sid = request.getParameter("sid");
		String password = request.getParameter("pwd");
		
		String inCode = request.getParameter("code");
		HttpSession session = request.getSession();
		
		char[] code=(char[])session.getAttribute("authCode");
		String outCode = new String(code);
		if(inCode.equals(outCode)){
			User user = new User();
			user.setName(name);
			user.setSid(sid);
			user.setPassword(password);
			user.setSex(sex);
			UserService service = new UserService();
			boolean flag=service.register(user);
			
			if(flag){
				response.getWriter().println("register ok !");
			}else{
				response.getWriter().println("register failed !");
			}
			
		}else{
			response.getWriter().write("Code fail!");
		}
		
	}

}
