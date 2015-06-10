package com.myhouse.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhouse.entity.District;
import com.myhouse.entity.HouseInfo;
import com.myhouse.entity.HouseType;
import com.myhouse.entity.Street;
import com.myhouse.entity.User;
import com.myhouse.myhouseUtils.Datechange;
import com.myhouse.service.DistrictService;
import com.myhouse.service.HouseInfoService;
import com.myhouse.service.HouseTypeService;
import com.myhouse.service.StreetService;

public class ListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ListServlet() {
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
		//response.setContentType("text/html;charset = utf-8");
		//request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("op");
		if ("list".equals(action)) {
			list(request, response);
		} else if ("del".equals(action)) {
			del(request, response);
		}else if("editprepare".equals(action)){
			editprepare(request, response);
		}else if("edit".equals(action)){
			edit(request, response);
		}
		out.close();
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagestr = request.getParameter("page");
		int pageindex = 1;
		if (pagestr == null) {
			pageindex = 1;
		}
		if (pagestr != null && !"".equals(pagestr)) {
			pageindex = Integer.valueOf(pagestr);
		}
		HttpSession session = request.getSession();
		Object object = session.getAttribute("loginuser");
		User us = (User) object;
		String name = us.getName();
		HouseInfoService service = new HouseInfoService();
		int pagecount = service.getPageCountByName(Datechange.PAGESIZE, name);
		List<HouseInfo> list = service.selHousesByName(name, pageindex,
				Datechange.PAGESIZE);
		for (HouseInfo house : list) {
			String dist = service.selDistrictTypeById(house.getDistrict_id());
			String str = service.selStreetTypeById(house.getStreet_id());
			request.setAttribute("district", dist);
			request.setAttribute("street", str);
		}
		//读取cookie的值
		Cookie [] cookies =  request.getCookies();
	
		for (Cookie cookie : cookies) {
			if("keys".equals(cookie.getName())){
				String key = cookie.getValue();
				key = URLDecoder.decode(key, "utf-8");
				String [] keys = key.split(",");
				request.setAttribute("cookie", keys);	
			}
		}
		
		
		
		request.setAttribute("houselist", list);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pageindex", pageindex);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		int delId = Integer.valueOf(id);
		HouseInfoService service = new HouseInfoService();
		int result = service.delHouse(delId);
		if (result == 1) {
			out.print("<script>alert('删除成功');</script>");
			response.sendRedirect("ListServlet?op=list");

		} else if (result == 0) {
			out.print("<script>alert('其他原因，删除失败');history.go(-1);</script>");
		} else if (result == -1) {
			out
					.print("<script>alert('数据库中没有这条数据，删除失败');history.go(-1);</script>");
		}
	}
	public void editprepare(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id = request.getParameter("id");
		HouseInfoService service = new HouseInfoService();
		HouseInfo house = service.selHouseByID(Integer.valueOf(id));
		HouseTypeService htypeservice = new HouseTypeService();
		List<HouseType> htlist = htypeservice.selAllType();
		HouseType htype= htypeservice.selHouseTypeById(house.getHousetype());
		DistrictService disservice = new DistrictService();
		List<District> dislist = disservice.selDistrict();
		District seldistrict = disservice.selDistrictById(house.getDistrict_id());
		StreetService strservice = new StreetService();
		Street selstreet = strservice.selStreetById(house.getStreet_id());
		List<Street> strlist = strservice.selStreet();
		request.setAttribute("htlist", htlist);
		request.setAttribute("dislist", dislist);
		request.setAttribute("seldistrict",seldistrict );
		request.setAttribute("strlist", strlist);
		request.setAttribute("selstreet", selstreet);
		request.setAttribute("htype", htype);
		
		request.setAttribute("result", house);
		request.getRequestDispatcher("edithouse.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session =  request.getSession();
		User ower = (User)session.getAttribute("loginuser");
		String owner = ower.getName();
		String title = request.getParameter("title");
		String housetype = request.getParameter("type_id");
		HouseType htype = new HouseType();
		htype.setId(Integer.valueOf(housetype));
		String floorage = request.getParameter("floorage");
		String price = request.getParameter("price");
		String housedate01 = request.getParameter("houseDate");
		Date housedate = Datechange.getDateByStr(housedate01, "yyyy-MM-dd");
		String district_id = request.getParameter("district_id");
		District district = new District();
		district.setId(Integer.valueOf(district_id));
		String street_id = request.getParameter("street_id");
		Street street = new Street();
		street.setId(Integer.valueOf(street_id));
		String contact = request.getParameter("contact");
		String content = request.getParameter("description");
		int id = Integer.valueOf(request.getParameter("id"));
		HouseInfo house = new HouseInfo(id, title, htype.getId(), floorage,
				price, housedate, district.getId(), street.getId(), contact,
				content, owner);
		HouseInfoService service = new HouseInfoService();
		int result = service.editHouse(house);
		if (result == 1) {
			response.sendRedirect("ListServlet?op=list");
		} else if (result == 0) {
			out.print("<script>alert('没有存入数据库');history.go(-1);</script>");
		} else if (result == -1) {
			out.print("<script>alert('没有找到该房屋信息');history.go(-1);</script>");
		}
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
			doGet(request, response);
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
