package page.index;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import pub.db.Database;

public class PageIndexDao {
	public List<PageIndex> query(){
		try {
			List<PageIndex> result = new ArrayList<PageIndex>();
			Connection con = Database.getConnection();
			String sql="select * from page_index order by id desc";
			
			Statement stmt=con.createStatement();                                                       
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				Long id = rs.getLong("id");
				String title = rs.getString("title");
				String explain = rs.getString("explain");
				String imgURL = rs.getString("imgURL");
				String btnURL = rs.getString("btnURL");
				String date=rs.getString("date");
				PageIndex pid = new PageIndex();
				pid.setDate(date);
				pid.setBtnURL(btnURL);
				pid.setExplain(explain);
				pid.setImgURL(imgURL);
				pid.setTitle(title);
				result.add(pid);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ArrayList<PageIndex>();
	}
	
	public static void main(String[] args) {
		//测试查询
		PageIndexDao dao = new PageIndexDao();
		List<PageIndex> pids = dao.query();
		if(pids!=null){
			for(PageIndex pid:pids){
				System.out.println(pid.getTitle());
				String date = pid.getDate();
				System.out.println(date);
				System.out.println(pid.getBtnURL());
				System.out.println(pid.getExplain());
				System.out.println(pid.getImgURL());
				String[] strs=date.split("-");
				for(int i=0;i<strs.length;i++){
					System.out.println(strs[i]);
				}
	}
	}
		
		//测试插入
//		Message msg = new Message();
//		Timestamp date = new Timestamp(System.currentTimeMillis());
//		System.out.println();
//		msg.setDate(date);
//		msg.setName("阿妹");
//		msg.setSpeak("小龙人你好");
//		System.out.println(dao.insert(msg));
	}
}
