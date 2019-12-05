package cn.itcast.chapter11.model12.domin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

@WebServlet("/RegisterFormBean")
public class RegisterFormBean {
			private String name;
			private String password;
			private String password2;
			private String email;
			private Map<String,String> errors = new HashMap<String,String>();
			public String getname(){
				return name;
			}
			public void setname(String name){
				this.name=name;
			}
			public String getpassword(){
				return password;
			}
			public void setpassword(String password){
				this.password=password;
			}
			public String getpassword2(){
				return password2;
			}
			public void setpassword2(String password2){
				this.password2=password2;
			}
			public String getEmail(){
				return email;
			}
			public void setEmail(String email){
				this.email=email;
			}
			public boolean validate(){
				boolean flag=true;
				if(name==null||name.trim().equals("")){
					errors.put("name","请输入姓名");
					flag=false;
				}
				if(password==null||password.trim().equals("")){
					errors.put("password","请输入密码");
					flag=false;
				}
				else if(password.length()>12||password.length()<6){
					errors.put("password","请输入6-12个字符！");
					flag=false;
				}
				if(password!=null&&!password.equals(password2)){
					errors.put("password2","两次输入的密码不匹配！");
					flag=false;
				}
				if(email==null||email.trim().equals("")){
					errors.put("email","请输入邮箱");
					flag=false;
				}
				else if(!email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+")){
					errors.put("email","邮箱格式错误。");
					flag=false;
				}
				return flag;
			}
			public void setErrorMsg(String err,String errMsg){
				if((err!=null)&&(errMsg!=null)){
					errors.put(err,errMsg);
				}
			}
			public Map<String,String> getErrors(){
				return errors;
			}
}
