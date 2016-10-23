package com.atwjsw.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 原生的AJAX和JQuery调用的服务端，返回JSON格式
 * 
 */
public class JSONServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number = req.getParameter("number");
		resp.setContentType("application/json;charset=utf-8"); //让浏览器知道响应的格式和怎样处理		
		PrintWriter out = resp.getWriter();
		if (number == null || number.isEmpty()) {
			out.println("{\"success\":false, \"msg\":\"参数错误\"}");
		} else {
			Employee e = search(number);
			if (e==null) {
				out.print("{\"success\":false, \"msg\":\"没有找到员工\"}");
			} else {
				out.print("{\"success\":true, \"msg\":\"发现员工： " + e + "\"}");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String job = req.getParameter("job");
		System.out.println(name);
		resp.setContentType("application/json;charset=utf-8"); //让浏览器知道响应的格式和怎样处理
		PrintWriter out = resp.getWriter();
		
		if ((number!=null && !number.isEmpty()) && (name!=null && !name.isEmpty()) && (job!=null && !job.isEmpty())) {
			out.println("{\"success\":true, \"msg\":\"员工保存成功 ：  " + new Employee(number, name, job) + "\"}");			
		} else {
			out.println("{\"success\":false, \"msg\":\"员工信息填写不全\"}");
		}
	}

	private Employee search(String number) {
		
		Map<String, Employee> employees = new HashMap<String, Employee>(); 
		Employee e1 = new Employee("101","洪七","总经理");
		Employee e2 = new Employee("102","郭靖","开发工程师");
		Employee e3 = new Employee("103","黄蓉","产品经理");
		employees.put("101", e1);
		employees.put("102", e2);
		employees.put("103", e3);	
		
		return employees.get(number);		
	}

}
