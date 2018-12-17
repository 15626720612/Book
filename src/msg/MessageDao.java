package msg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import pub.db.Database;

public class MessageDao {
	public List<Message> query(int pageSize,int page){
		try {
			List<Message> result = new ArrayList<Message>();
			Connection con = Database.getConnection();
			String sql="select * from gbook order by id desc";
			
			page=(page<=0)?1:page;
			sql=sql+" limit "+(page-1)*pageSize+","+pageSize;
			
			Statement stmt=con.createStatement();                                                       
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String date=rs.getString("saydate");
				String speak = rs.getString("speak");
				Message msg = new Message();
				msg.setDate(date);
				msg.setName(name);
				msg.setSpeak(speak);
				msg.setId(id);
				result.add(msg);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ArrayList<Message>();
	}
	
	public boolean insert(Message msg){
		try {
			Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			String sql = "insert into gbook (name,saydate,speak) value ('"+msg.getName()+"','"+msg.getDate()+"','"+msg.getSpeak()+"')";
			stmt.execute(sql);
			con.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public int getSize(){
		int size = 0;
		try {
			Connection con = Database.getConnection();
			String sql="select count(*) from gbook";
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				size = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                       
		
		return size;
	}
	
	public static void main(String[] args) {
		//测试查询
//		MessageDao dao = new MessageDao();
//		List<Message> msgs = dao.query(10, 2);
//		if(msgs!=null){
//			for(Message m:msgs){
//				System.out.println(m.getSpeak());
//				System.out.println(m.getDate());
//			}
//		}
		
		//测试插入
//		Message msg = new Message();
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss"); 
//		String dateStr = df.format(date); 
//		System.out.println(date);
//		msg.setDate(dateStr);
//		msg.setName("阿妹");
//		msg.setSpeak("小龙人你好");
//		System.out.println(dao.insert(msg));
	}
}
