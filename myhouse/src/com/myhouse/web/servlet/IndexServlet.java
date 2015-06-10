package com.myhouse.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myhouse.entity.HouseInfo;
import com.myhouse.myhouseUtils.Datechange;
import com.myhouse.service.HouseInfoService;

public class IndexServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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
		//传过来一个op的参数。根据传过来的op参数值来决定运行哪一个方法。
		String action = request.getParameter("op");
		if ("search".equals(action)) {
			search(request, response);
		} else if ("detail".equals(action)) {
			detail(request, response);
		}
		out.close();
	}

	/*
	 * public void list(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { HouseInfoService service
	 * = new HouseInfoService(); String pagestr = request.getParameter("page");
	 * int pageindex = 1; if (pagestr == null) { pageindex = 1; } if (pagestr !=
	 * null && !"".equals(pagestr)) { pageindex = Integer.valueOf(pagestr); }
	 * int pagecount = service.getPageCount(Datechange.PAGESIZE);
	 * List<HouseInfo> list = service.selHousesByPage(pageindex,
	 * Datechange.PAGESIZE); for (HouseInfo house : list) { String dist =
	 * service.selDistrictTypeById(house.getDistrict_id()); String str =
	 * service.selStreetTypeById(house.getStreet_id()); String type =
	 * service.selHouseTypeById(house.getHousetype());
	 * request.setAttribute("district", dist); request.setAttribute("street",
	 * str); request.setAttribute("type", type); request.setAttribute("price",
	 * house.getPrice()); request.setAttribute("street_id",
	 * house.getStreet_id()); request.setAttribute("type_id",
	 * house.getHousetype()); request.setAttribute("floorage",
	 * house.getFloorage()); } request.setAttribute("result", list);
	 * request.setAttribute("pageindex", pageindex);
	 * request.setAttribute("pagecount", pagecount);
	 * request.getRequestDispatcher("index.jsp").forward(request, response); }
	 */

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

	public void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HouseInfoService service = new HouseInfoService();
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		int low_price = 0;
		int high_price = 0;
		String street_id = request.getParameter("street_id");
		String type_id = request.getParameter("type_id");
		String floorage = request.getParameter("floorage");
		int low_floorage = 0;
		int high_floorage = 0;
		if (title == null) {
			title = "";
		}
		if (price == null) {
			price = "";
		}
		if (street_id == null) {
			street_id = "";
		}
		if (type_id == null) {
			type_id = "";
		}
		if (floorage == null) {
			floorage = "";
		}
		// 如果所有的值都为空，说明不涉及搜索，只是单纯显示所有信息。
		if ("".equals(title) && "".equals(price) && "".equals(street_id)
				&& "".equals(type_id) && "".equals(floorage)) {
			String pagestr = request.getParameter("page");
			int pageindex = 1;
			if (pagestr == null) {
				pageindex = 1;
			}
			if (pagestr != null && !"".equals(pagestr)) {
				pageindex = Integer.valueOf(pagestr);
			}
			int pagecount = service.getPageCount(Datechange.PAGESIZE);
			List<HouseInfo> list = service.selHousesByPage(pageindex,
					Datechange.PAGESIZE);
			
			for (HouseInfo house : list) {
				String dist = service.selDistrictTypeById(house
						.getDistrict_id());
				String str = service.selStreetTypeById(house.getStreet_id());
				String type = service.selHouseTypeById(house.getHousetype());
				request.setAttribute("district", dist);
				request.setAttribute("street", str);
				request.setAttribute("type", type);

			}
			request.setAttribute("result", list);
			request.setAttribute("pageindex", pageindex);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("price", price);
			request.setAttribute("street_id", street_id);
			request.setAttribute("type_id", type_id);
			request.setAttribute("floorage", floorage);
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);

		} else {
			if ("".equals(price)) {
				low_price = 0;
				high_price = 0;
			} else if ("0-100".equals(price)) {
				low_price = 0;
				high_price = 100;
			} else if ("100-200".equals(price)) {
				low_price = 100;
				high_price = 200;
			} else if ("200-1000000".equals(price)) {
				low_price = 200;
				high_price = 1000000;
			}
			if ("".equals(street_id)) {
				street_id = "";
			}
			if ("".equals(type_id)) {
				type_id = "";
			}
			if ("".equals(floorage)) {
				low_floorage = -1;
				high_floorage = -1;
			} else if ("0-40".equals(floorage)) {
				low_floorage = 0;
				high_floorage = 40;
			} else if ("40-500".equals(floorage)) {
				low_floorage = 40;
				high_floorage = 500;
			} else if ("500-1000000".equals(floorage)) {
				low_floorage = 500;
				high_floorage = 1000000;
			}
			//首先读取cookie的值，判断原先是否已经有值了。
			String key = "";
			Cookie [] cookies =  request.getCookies();
			for (Cookie cookie : cookies) {
				if("keys".equals(cookie.getName())){
					key = cookie.getValue();
				//	key = URLDecoder.decode(key, "utf-8");
				}
			}
			title = new String(title.getBytes("iso-8859-1"), "utf-8");
			//设置cookie
			if(!"".equals(title)){
				//cookie不支持中文，所以要先转码
				String t = URLEncoder.encode(title, "utf-8");
				if(!"".equals(key)){
					t=key+","+t;
				}
				Cookie cookiekeys = new Cookie("keys", t);
				cookiekeys.setMaxAge(1000*60*60*24*7);
				cookiekeys.setPath("/");
				response.addCookie(cookiekeys);
			}
			String pagestr = request.getParameter("page");
			int pageindex = 1;
			if (pagestr == null) {
				pageindex = 1;
			}
			if (pagestr != null && !"".equals(pagestr)) {
				pageindex = Integer.valueOf(pagestr);
			}
			int pagecount = service.getPageCountByAll(Datechange.PAGESIZE,
					low_price, high_price, title, type_id, street_id,
					low_floorage, high_floorage);
			if (pagecount == 0) {
				pageindex = pagecount;
				request.setAttribute("message", "没有搜索到相关内容");
			}
			if(pagecount!=0){
			List<HouseInfo> list = service.search(pageindex,
					Datechange.PAGESIZE, low_price, high_price, title, type_id,
					street_id, low_floorage, high_floorage);
			for (HouseInfo house : list) {
				String dist = service.selDistrictTypeById(house
						.getDistrict_id());
				String str = service.selStreetTypeById(house.getStreet_id());
				String type = service.selHouseTypeById(house.getHousetype());
				request.setAttribute("district", dist);
				request.setAttribute("street", str);
				request.setAttribute("type", type);

			}	
			request.setAttribute("result", list);
			request.setAttribute("title", title);
			request.setAttribute("price", price);
			request.setAttribute("street_id", street_id);
			request.setAttribute("type_id", type_id);
			request.setAttribute("floorage", floorage);
			}
			request.setAttribute("pageindex", pageindex);
			request.setAttribute("pagecount", pagecount);
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

	public void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id =  request.getParameter("id"); 
		HouseInfoService service = new HouseInfoService(); 
		HouseInfo house = service.selHouseByID(Integer.valueOf(id)); 
		String housetype =  service.selHouseTypeById(house.getHousetype()); 
		String district = service.selDistrictTypeById(house.getDistrict_id()); 
		String street = service.selStreetTypeById(house.getStreet_id()); 
		request.setAttribute("house", house);
		request.setAttribute("housetype", housetype);
		request.setAttribute("district", district);
		request.setAttribute("street", street);
		request.getRequestDispatcher("details.jsp").forward(request, response);
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
