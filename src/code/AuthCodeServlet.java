package code;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**生成并发送验证码图片给客户端*/
@WebServlet("/servlet/code/authCode")
public class AuthCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//生成验证码
		char[] code=AuthCodeBuilder.generateCode();
		BufferedImage img=AuthCodeBuilder.drawCode(code);
		//利用会话存储验证码，以跨请求共享数据
		HttpSession session=request.getSession();
//		session.setMaxInactiveInterval(60);//以秒为单位，60秒会话没被使用过就销毁它
		session.setAttribute("authCode", code);
		//把验证码发送给客户端
		response.setContentType("image/jpeg");
		OutputStream out=response.getOutputStream();
		ImageIO.write(img, "jpeg", out);
	}

}
