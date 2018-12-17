package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pub.db.Database;

/**对用户数据进行CRUD操作*/
public class UserDao {
	/**
	 *按条件进行分页查询
	 *@param param 封装查询条件的java对象
	 *       pageSize 每页显示多少条记录
	 *       page     显示第几页
	 *@return 若没有符合条件的结果返回大小为0的列表，否则返回符合条件的数据对象。       */
	public List<User> query(){
		try{
			List<User> result=new ArrayList<User>();
			Connection con=Database.getConnection();
			String sql="select * from user";

			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String sid=rs.getString("Id");
				String name=rs.getString("name");
				String password=rs.getString("pwd");
				String sex = rs.getString("sex");
				User user=new User();
				user.setSid(sid);
				user.setName(name);
				user.setPassword(password);
				user.setSex(sex);
				result.add(user);
			}
			con.close();
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ArrayList();
	}
	public boolean insert(User user){
		try{
			Connection con=Database.getConnection();
			Statement stmt=con.createStatement();
			String sql="insert into user (Id,name,sex,pwd) values ('"+user.getSid()+"','"+user.getName()+"','"+user.getSex()+"','"+user.getPassword()+"')";
			stmt.execute(sql);
			con.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*public boolean update(User student){
		try{
			Connection con=Database.getConnection();
			Statement stmt=con.createStatement();
			System.out.println(student.getSid());
			String sql="update tb_student set name='"+student.getName()
					+"',age='"+student.getAge()
					+"',sex='"+student.getSex()
					+"',stu_class='"+student.getStu_class()
					+"',login_num='"+student.getLogin_num()
					+"',pwd='"+student.getPassword()
					+"' where sid='"+student.getSid()+"'";
			stmt.execute(sql);
			con.close();
			return true;//没有修改成功也返回真？！假如ID不存在也会返回真
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}*/
	public static void main(String[] args) {
		//测试查询
//		Student student=new Student();
//		student.setName("张三");student.setPassword("12345");
//		StudentDao dao=new StudentDao();
//		List<Student> students=dao.query(null, 10, 1);//无条件查询
//		if(students!=null){
//			for(Student s:students){
//				System.out.println(s.getName());
//			}
//		}
//		System.out.println("---------------------------");
//		students=dao.query(student, 10, 1);//带用户名作为条件进行查询
//		if(students!=null){
//			for(Student u:students){
//				System.out.println(u.getName());
//			}
//		}
		
		//测试插入
//		Student student =  new Student();
//		student.setName("阿妹");
//		student.setAge(12);
//		student.setSid("20165533207");
//		student.setLogin_num("amei");
//		student.setPassword("abcde");
//		student.setSex("女");
//		student.setStu_class("APP应用一班");
//		StudentDao dao = new StudentDao();
//		System.out.println(dao.insert(student));
		
//		测试更新
//		Student student =  new Student();
//		student.setSid("20165533203");
//		student.setName("嘿宇");
//		student.setAge(12);
//		student.setLogin_num("amei");
//		student.setPassword("abcde");
//		student.setSex("男");
//		student.setStu_class("APP应用一班");
//		StudentDao dao = new StudentDao();
//		System.out.println(dao.update(student));
	}
}

