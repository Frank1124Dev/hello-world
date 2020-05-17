package com.itheima.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;
import com.itheima.util.DBUtil;

public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.getSession();
		
		out.print("本网站有以下好书：<br/>");
		Map<String,Book> books= DBUtil.showAllBooks();
		for(Map.Entry<String, Book> book : books.entrySet()){
			String url = request.getContextPath()+"/servlet/addCart?id="+book.getKey();
			out.print("<a href='"+response.encodeURL(url)+"' >"+" 《"+book.getValue().getName()+"》 "+"</a><br/>");
		}
		
		String url2=request.getContextPath()+"/servlet/showCart";
		out.print("<a href='"+response.encodeURL(url2)+"' >查看购物车</a>");
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
