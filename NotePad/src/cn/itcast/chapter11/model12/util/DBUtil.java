package cn.itcast.chapter11.model12.util;

import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import cn.itcast.chapter11.model12.domin.UserBean;

@WebServlet("/DBUtil")
public class DBUtil {
		private static DBUtil instance=new DBUtil();
		private HashMap<String,UserBean> users=new HashMap<String,UserBean>();
		private DBUtil(){
			UserBean user1=new UserBean();
			user1.setName("Jack");
			user1.setPassword("12345678");
			user1.setEmail("jack@it315.org");
			users.put("Jack", user1);
			UserBean user2=new UserBean();
			user2.setName("Rose");
			user2.setPassword("12345678");
			user2.setEmail("Rose@it315.org");
			users.put("Rose", user2);
		}
		public UserBean getUser(String userName){
			UserBean user=(UserBean) users.get(userName);
			return user;
		}
		public boolean insertUser(UserBean user){
			if(user==null){
				return false;
			}
			String userName=user.getName();
			if(users.get(userName)!=null){
				return false;
			}
			users.put(userName,user);
			return true;
		}
		public static DBUtil getInstance() {
			// TODO Auto-generated method stub
			return instance;
		}
}
