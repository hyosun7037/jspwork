package com.cos.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 
 * 한글 테스트 
 * 데이터 전달 
 * 데이터 응답
 *
 */
@WebServlet("/postman")
public class EncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EncServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get 요청옴");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post 요청옴");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
	
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		
	}

	// PUT과 DELETE는 x-www-formurlencoded 파싱이 안됨
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Put 요청옴");
//		request.setCharacterEncoding("UTF-8");
//		String username = request.getParameter("username");
//		System.out.println("Post 받은 값 : " +username);
		BufferedReader br = req.getReader(); //파싱안하고 그대로 받기 = BufferedReader
		String data = null;
		StringBuilder sb = new StringBuilder();
		while((data=br.readLine())!=null) {
			System.out.println(data);
			sb.append(data);
		}
//		System.out.println(br.readLine());
		Gson gson = new Gson();
		User user = gson.fromJson(sb.toString(), User.class);
		//DB에 인서트하면 끝
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Delete 요청옴");
		BufferedReader br = req.getReader();
		
	}
}
