package com.myhouse.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.myhouse.entity.District;
import com.myhouse.entity.FileInfo;
import com.myhouse.entity.HouseInfo;
import com.myhouse.entity.HouseType;
import com.myhouse.entity.Street;
import com.myhouse.entity.User;
import com.myhouse.myhouseUtils.Datechange;
import com.myhouse.myhouseUtils.GetFileName;
import com.myhouse.service.DistrictService;
import com.myhouse.service.FileInfoService;
import com.myhouse.service.HouseInfoService;
import com.myhouse.service.HouseTypeService;
import com.myhouse.service.StreetService;

public class PublicServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PublicServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8");
	//	response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		HouseTypeService service = new HouseTypeService();
		List<HouseType> list = service.selAllType();
		request.setAttribute("type", list);
		DistrictService disservice = new DistrictService();
		List<District> dis = disservice .selDistrict();
		request.setAttribute("district", dis);
		StreetService strservice = new StreetService();
		List<Street> street = strservice .selStreet();
		request.setAttribute("street", street);
		request.getRequestDispatcher("public.jsp").forward(request, response);
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset = utf-8");
		String title = "";
		String housetype = "";
		String floorage = "";
		String price = "";
		String housedate01 = "";
		String district_id = "";
		String street_id = "";
		String contact = "";
		String content = "";
		String filename = "";
		String filepath = "";
		HouseType htype = null;
		Date housedate = null;
		District district = null;
		Street street = null;
		HttpSession session =  request.getSession();
		User ower = (User)session.getAttribute("loginuser");
		 String name =  ower.getName();
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 factory.setRepository(new File("D:/temp"));
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 //是判断是普通表单，还是带文件上传的表单
		 if(upload.isMultipartContent(request)){
			 try {
				List<FileItem> fileitems =(List<FileItem>) upload.parseRequest(request);
				for (FileItem fileItem : fileitems) {
					//判断一个参数域是普通的表单输入域,还是文件上传域
					if(fileItem.isFormField()){
						String nametest = fileItem.getFieldName();
						String value = fileItem.getString();
						value = new String(value.getBytes("iso-8859-1"),"utf-8");
						if("title".equals(nametest)){
							title = value;
						}else if("type_id".equals(nametest)){
							housetype = value;
							 htype = new HouseType();
							htype.setId(Integer.valueOf(housetype));
						}else if("floorage".equals(nametest)){
							floorage = value;
						}else if("price".equals(nametest)){
							price =value;
						}else if("houseDate".equals(nametest)){
							housedate01=value;
							housedate = Datechange.getDateByStr(housedate01, "yyyy-MM-dd");
						}else if("district_id".equals(nametest)){
							district_id=value;
							district = new District();
							district.setId(Integer.valueOf(district_id));
						}else if("street_id".equals(nametest)){
							street_id=value;
							street = new Street();
							street.setId(Integer.valueOf(street_id));
						}else if("contact".equals(nametest)){
							contact=value;
						}else if("content".equals(nametest)){
							content=value;
						}
					}else{
						 filename = fileItem.getName();
						//得到后缀名ext
						String ext = filename.substring(filename.lastIndexOf("."));
						String upload_parent =request.getSession().getServletContext().getRealPath("/")+"upload";
						filename = GetFileName.GetRamdomFileName()+ext;
						File file = new File(upload_parent, filename);
						file.createNewFile();
						InputStream ins = fileItem.getInputStream();
						FileOutputStream outs = new FileOutputStream(file);
						byte [] datas = new byte[1024];
						int len = 0;
						while((len = ins.read(datas))>0){
							outs.write(datas,0,len);
						}
						filepath = filename;
						outs.close();
						ins.close();
						fileItem.delete();
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		HouseInfo house = new HouseInfo(title, htype.getId(), floorage, price,
				housedate, district.getId(), street.getId(), contact, content,name);
		HouseInfoService service = new HouseInfoService();
		int result = service.addHouse(house);
		if (result == 1) {
			//response.sendRedirect("ListServlet?op=list");
		} else if (result == 0) {
			out.print("<script>alert('没有存入数据库');history.go(-1);</script>");
		} else if (result == -1) {
			out.print("<script>alert('该房屋已存在，不可重复存储');history.go(-1);</script>");
		}
		FileInfo fileinfo = new FileInfo(filename, filepath, name);
		FileInfoService fileservice = new FileInfoService();
		int fileresult = fileservice.insertFile(fileinfo);
		if (fileresult == 1) {
			response.sendRedirect("ListServlet?op=list");
		} else if (fileresult == 0) {
			out.print("<script>alert('文件没有存入数据库');history.go(-1);</script>");
		} else if (fileresult == -2) {
			out.print("<script>alert('该文件没有进入数据库开展操作');history.go(-1);</script>");
		}
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
