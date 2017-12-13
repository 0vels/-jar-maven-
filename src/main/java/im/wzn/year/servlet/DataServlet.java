package im.wzn.year.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import im.wzn.year.calendarconverter.LunarProgress;

@WebServlet("/getPercent")
public class DataServlet extends HttpServlet {
	private String message;

	public void init() throws ServletException {
		// 执行必需的初始化
		message = "Hello World!!!";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html");
		
		// 实际的逻辑是在这里
		PrintWriter out = response.getWriter();
		//添加一个百分比
		out.println("<h1>" + LunarProgress.getPercent() + "</h1>");
	}

	public void destroy() {
		// 什么也不做
	}
}
