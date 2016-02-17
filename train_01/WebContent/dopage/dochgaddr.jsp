<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.Address"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理修改地址控制器
	// 设置编码
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	// 获取要修改的地址编号
	String aid = request.getParameter("aid");
	// 获取修改的数据
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
	
	// 根据要修改的编号查询对应的地址对象
	AddressService service = new AddressService();
	Address addr = service.findById(aid);
	// 设置新数据
	addr.setAnation(anation);
	addr.setProvince(province);
	addr.setCity(city);
	addr.setCountry(country);
	addr.setStreet(street);
	addr.setAdesc(adesc);
	addr.setStatus(isDef);
	addr.setContact(contact);
	addr.setPhone(phone);
	
	// 更新地址数据
	service.updateAddr(addr); 
	
	// 更新完成，跳转回查看所有地址页面
	response.sendRedirect("dofindaddr.jsp");
%>