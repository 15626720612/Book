package page.manshenghuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import page.index.PageIndex;
import pub.db.Database;

public class MshReadDao {
	public List<MshRead> query(int page,int pageSize){
		try {
			List<MshRead> result = new ArrayList<MshRead>();
			Connection con = Database.getConnection();
			String sql="select * from page_msh_read order by id desc";
			
			sql=sql+" limit "+(page-1)*pageSize+","+pageSize;
			
			Statement stmt=con.createStatement();                                                       
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				String title = rs.getString("read_title");
				String author = rs.getString("read_author");
				String imgUrl = rs.getString("read_imgUrl");
				String essayUrl = rs.getString("read_essayUrl");
				String brief=rs.getString("read_brief");
				MshRead read = new MshRead();
				read.setAuthor(author);
				read.setBrief(brief);
				read.setEssayUrl(essayUrl);
				read.setImgUrl(imgUrl);
				read.setTitle(title);
				result.add(read);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ArrayList<MshRead>();
	}
	
	/**返回大小*/
	public int getSize(){
		int size = 0;
		try {
			Connection con = Database.getConnection();
			String sql="select count(*) from page_msh_read";
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
		MshReadDao dao = new MshReadDao();
		System.out.println(dao.getSize());
	}
}
