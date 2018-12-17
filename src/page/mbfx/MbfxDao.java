package page.mbfx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import page.manshenghuo.MshSentence;
import pub.db.Database;

public class MbfxDao {
	public List<Mbfx> query(int page,int pageSize){
		try {
			List<Mbfx> result = new ArrayList<Mbfx>();
			Connection con = Database.getConnection();
			String sql="select * from page_mbfx ";
			
			sql=sql+" limit "+(page-1)*pageSize+","+pageSize;
			
			Statement stmt=con.createStatement();                                                       
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				String title = rs.getString("mbfx_title");
				String imgUrl=rs.getString("mbfx_imgUrl");
				String bookUrl = rs.getString("mbfx_bookUrl");
				String brief = rs.getString("mbfx_brief");
				
				Mbfx mbfx = new Mbfx();
				mbfx.setBookUrl(bookUrl);
				mbfx.setBrief(brief);
				mbfx.setImgUrl(imgUrl);
				mbfx.setTitle(title);
				result.add(mbfx);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ArrayList<Mbfx>();
	}
	public int getSize(){
		int size = 0;
		try {
			Connection con = Database.getConnection();
			String sql="select count(*) from page_mbfx";
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
}
