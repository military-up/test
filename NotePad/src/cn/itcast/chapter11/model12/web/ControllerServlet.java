package cn.itcast.chapter11.model12.web;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.chapter11.model12.domin.RegisterFormBean;
import cn.itcast.chapter11.model12.domin.UserBean;
import cn.itcast.chapter11.model12.util.DBUtil;
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			this.doPost(request, response);
		}
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			response.setHeader("Content-type", "text/html;charset=GBK");
			response.setCharacterEncoding("GBK");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String password2=request.getParameter("password2");
			String email=request.getParameter("email");
			RegisterFormBean formBean=new RegisterFormBean();
			formBean.setname(name);
			formBean.setpassword(password);
			formBean.setpassword(password2);
			formBean.setEmail(email);
			if(!formBean.validate()){
				request.setAttribute("formBean",formBean);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			UserBean userBean=new UserBean();
			userBean.setName(name);
			userBean.setPassword(password);
			userBean.setEmail(email);
			boolean b=DBUtil.getInstance().insertUser(userBean);
			if(!b){
				request.setAttribute("DBMes", "你注册的用户已存在！");
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			response.getWriter().print("恭喜你注册成功，将在三秒后跳转！");
			request.getSession().setAttribute("userBean", userBean);
			response.setHeader("refresh", "3;url=loginSuccess.jsp");
	   }
}
