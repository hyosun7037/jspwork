package com.cos.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/hello") //어노테이션 : 자바가 읽는 주석, /Hello 요청이 들어오면 Hello.java 파일을 찾기
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("request Get"); 
		PrintWriter out = response.getWriter();
		String name = "cos";
		out.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>test</title>\r\n" + 
				"    <style>\r\n" + 
				"        h1, table, td{\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"       table, td{\r\n" + 
				"        border-collapse: collapse;\r\n" + 
				"        border:2px solid black;\r\n" + 
				"        margin: 0 auto;\r\n" + 
				"        max-width: 1000px;\r\n" + 
				"       }\r\n" + 
				"        td{\r\n" + 
				"            width: 100px; height: 100px; \r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"    <h1>TITLE</h1>\r\n" + 
				"    <table>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>A</td>\r\n" + 
				"            <td >B</td>\r\n" + 
				"            <td>C</td>\r\n" + 
				"            <td>D</td>\r\n" + 
				"            <td>E</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>a</td>\r\n" + 
				"            <td>b</td>\r\n" + 
				"            <td>c</td>\r\n" + 
				"            <td>d</td>\r\n" + 
				"            <td>e</td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"</body>\r\n" + 
				"</html>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		System.out.println("request Post");
	} 

}
