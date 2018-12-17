package user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import sun.misc.Signal;


/**封装用户管理相关的业务逻辑*/
public class UserService {
	public boolean register(User user){
		//TODO 1.用户名是否重复
		//2.密码必须>6位
//		System.out.println(student.getSid());
		if(user.getPassword().length()<=6){
			return false;//密码强度不够，不允许注册
		}
		
		//用户注册资料符合业务规则，将数据写入数据库
		UserDao dao=new UserDao();
		return dao.insert(user);
	}
	/*public boolean update(User student){
		UserDao dao = new UserDao();
		return dao.update(student);
	}
	*/
	public Map<String,Object> login(User user){
		boolean f=false;
		Map<String,Object> map = new HashMap<String, Object>();
		UserDao dao=new UserDao();
		List<User> users=dao.query();//无条件查询
		User loginUser;
		if(users!=null){
			for(User u:users){
//				System.out.println(s.getName());
//				System.out.println(s.getLogin_num());
				if(user.getSid().equals(u.getSid())&&user.getPassword().equals(u.getPassword())){
					f=true;
					loginUser=u;
//					System.out.println(loginUser.getSid());
//					System.out.println(u.getSid());
					map.put("user", loginUser);
				}
			}
		}
		map.put("f", f);
		return map;
		
	}
	
	public static void main(String[] args) {
//		StudentService service=new StudentService();
//		Student student=new Student();
		//1.测试密码强度不够，注册失败
//		student.setName("test");student.setPassword("123");
//		System.out.println(service.register(student));
//		System.out.println(service.update(student));
		//2.测试成功
//		student.setName("ad");student.setPassword("12345678");
//		System.out.println(service.register(student));
		//测试登陆
//		student.setLogin_num("long");
//		student.setPassword("123");
//		Map<String,Object> map = service.login(student);
//		boolean f = (Boolean) map.get("f");
//		Student signStu = (Student)map.get("student");
//		System.out.println(f);
//		System.out.println(signStu);
	}

}


