package page.manshenghuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pub.db.Database;

public class MshSentenceDao {
	public List<MshSentence> query(){
		try {
			List<MshSentence> result = new ArrayList<MshSentence>();
			Connection con = Database.getConnection();
//			String sql="select * from page_msh_sen order by id desc";
			String sql="select * from page_msh_sen limit 8 ";
			
			Statement stmt=con.createStatement();                                                       
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				String sentence = rs.getString("sentence");
				String imgUrl=rs.getString("sen_imgUrl");
				MshSentence stn = new MshSentence();
				stn.setImgUrl(imgUrl);
				stn.setSentence(sentence);
				result.add(stn);
			}
			con.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ArrayList<MshSentence>();
	}
	public static void main(String[] args) {
		MshSentenceDao dao = new MshSentenceDao();
		List<MshSentence> stns = dao.query();
		if(stns!=null){
			for(MshSentence m:stns){
				System.out.println(m.getImgUrl());
				System.out.println(m.getSentence());
			}
		}
	}
}
