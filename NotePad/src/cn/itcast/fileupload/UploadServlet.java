package cn.itcast.fileupload;

import java.io.*;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f = new File("D:\\TempFolder");
			if(!f.exists()){
				f.mkdirs();
			}
			factory.setRepository(f);
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("utf-8");
			List<FileItem> fileitems = fileupload.parseRequest(req);
			PrintWriter writer = resp.getWriter();
			for(FileItem fileitem : fileitems){
				if(fileitem.isFormField()){
					String name = fileitem.getFieldName();
					if(name.equals("name")){
						if(!fileitem.getString().equals("")){
							String value = fileitem.getString("utf-8");
							writer.print("涓婁紶鑰咃細" + value + "<br />");
						}
					}
				}else {
					String filename = fileitem.getName();
					if(filename != null && !filename.equals("")){
						writer.print("涓婁紶鐨勬枃浠跺悕绉版槸锛�" + filename + "<br />");
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						filename = UUID.randomUUID().toString() + "_" + filename;
						String webpath = "/upload/";
						String filepath = getServletContext().getRealPath(webpath + filename);
						File file = new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						InputStream in = fileitem.getInputStream();
						FileOutputStream out = new FileOutputStream(file);
						byte[] buffer = new byte[1024];
						int len;
						while((len = in.read(buffer)) > 0){
							out.write(buffer, 0, len);
							in.close();
							out.close();
							fileitem.delete();
							writer.print("鏂囦欢涓婁紶鎴愬姛锛� <br />");
						}
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
			// TODO: handle exception
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
