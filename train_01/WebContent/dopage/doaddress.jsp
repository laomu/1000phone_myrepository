<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@page import="com.lzcc.train.model.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 添加收货地址
	// 设置编码
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	// 获取数据
	String anation = request.getParameter("anation");
	String province = request.getParameter("province");
	String city = request.getParameter("city");
	String country = request.getParameter("country");
	String street = request.getParameter("street");
	String adesc = request.getParameter("adesc");
	String contact = request.getParameter("contact");
	String phone = request.getParameter("phone");
	String def = request.getParameter("def");
	boolean isDef = false;
	if("2".equals(def)) {
		isDef = true;
	}
	
	// 验证数据
	if(anation == null || "".equals(anation.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在国家名称");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(province == null || "".equals(province.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在省名称");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(city == null || "".equals(city.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在市区名称");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(country == null || "".equals(country.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在县区名称");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(street == null || "".equals(street.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在街道名称");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(adesc == null || "".equals(adesc.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写地址详细信息");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(contact == null || "".equals(contact.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在收货人名称");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	if(phone == null || "".equals(phone.trim())) {
		request.setAttribute("ERROR_ADDR", "请填写所在收货人联系方式");
		request.getRequestDispatcher("../address.jsp").forward(request, response);
		return;
	}
	
	// 获取当前登录用户 
	User loginUser = (User) session.getAttribute("LOGINUSER");
	
	// 包装对象
	Address address = new Address(loginUser, anation, province, city, country, street, adesc, isDef, contact, phone);
	
	// 添加地址
	AddressService service = new AddressService();
	service.saveAddress(address);
	
	// 添加完成，跳转回查看所有地址页面
	response.sendRedirect("dofindaddr.jsp");
%>