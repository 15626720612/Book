package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**生成验证码的工具类*/
public class AuthCodeBuilder {
	public static final int WIDTH=600;//验证码图片宽高
	public static final int HEIGHT=200;
	public static final String chars="0123456789";//验证码字符表
	public static final int SIZE=4;//验证码的长度
	public static Random rdm=new Random(System.currentTimeMillis());//随机数生成器
	/**生成验证码内容*/
	public static char[] generateCode(){
		char[] code=new char[SIZE];
		for(int i=0;i<SIZE;i++){
			int idx=rdm.nextInt(chars.length());//nextInt(6)->0,1,2,3,4,5
			code[i]=chars.charAt(idx);
		}
		return code;
	}
	/**把验证码画成图片*/
	public static BufferedImage drawCode(char[] code){
		BufferedImage img=//创建一个空白的图片对象
	new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g=img.getGraphics();
		//画春色的背景，背景色RGB=DCDCDC
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//画验证码的内容
		Font font=new Font(null,Font.BOLD,65);//字体(宋体..),样式(加粗..),字号
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(""+code[0], 10, 170);
		g.drawString(""+code[1], 160, 150);
		g.drawString(""+code[2], 310, 180);
		g.drawString(""+code[3], 460, 160);
		//画干扰折线 
		int n=20;int[] x=new int[n],y=new int[n];
		for(int i=0;i<n;i++){//随机生成折线的端点
			x[i]=rdm.nextInt(WIDTH);
			y[i]=rdm.nextInt(HEIGHT);
		}
		g.setColor(Color.RED);
		g.drawPolyline(x, y, n);
		for(int i=0;i<n;i++){//随机生成折线的端点
			x[i]=rdm.nextInt(WIDTH);
			y[i]=rdm.nextInt(HEIGHT);
		}
		g.setColor(Color.ORANGE);
		g.drawPolyline(x, y, n);
		g.dispose();
		return img;
	}
	/**把图片保存到文件*/
	public static void writeImageFile(BufferedImage img){
		try{
			FileOutputStream fos=new FileOutputStream("d:/code.jpg");
			ImageIO.write(img, "jpeg", fos);
			fos.close();
		}catch(Exception e){e.printStackTrace();}
	}
	public static void main(String[] args){
		char[] code=generateCode();
		BufferedImage img=drawCode(code);
		writeImageFile(img);
	}
}
