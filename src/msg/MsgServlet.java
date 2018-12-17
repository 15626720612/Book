package msg;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

public class MsgServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("loginUser");
		String msgStr = "";
		if(request.getParameter("msg")!=null){
			msgStr=request.getParameter("msg");
		}
		String speak=new String(msgStr.getBytes("ISO8859-1"),"UTF-8");
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dateStr = df.format(date);
		Message msg = new Message();
		msg.setName(user.getName());
		msg.setDate(dateStr);
		msg.setSpeak(speak);
		
		MessageDao dao = new MessageDao();
		boolean f = dao.insert(msg);
		if(f&&user!=null){
			response.sendRedirect("/Book/book/gbook.jsp?msg="); 
		}else{
			response.getWriter().println("留言失败");
		}
	}
}
