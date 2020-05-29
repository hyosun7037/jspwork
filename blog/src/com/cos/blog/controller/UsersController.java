package com.cos.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.user.UsersJoinProcAction;
import com.cos.blog.action.user.UsersJoinAction;

//http://localhost:8000/blog/user
@WebServlet("/user")
public class UsersController extends HttpServlet {
	private final static String TAG = "UsersController : ";
	private static final long serialVersionUID = 1L;

	public UsersController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8000/blog/User?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "doProcess : " + cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}

	public Action router(String cmd) {
		if (cmd.equals("join")) { // 회원가입
			// 회원가입 페이지 이동
			return new UsersJoinAction();
		} else if (cmd.equals("joinProc")) {
			// 회원가입을 진행 한 후 -> index.jsp를 응답
			return new UsersJoinProcAction();
		} else if (cmd.equals("update")) {
			// 회원 수정 페이지로 이동 (세션에 User Object를 가지고 있을 예정, 뷰페이지로 이동)
		} else if (cmd.equals("updateProc")) {
			// 회원 수정을 진핼 한 후 -> index.jsp를 응답
		} else if (cmd.equals("delete")) {
			// 회원삭제을 진행 한 후 -> 로그아웃을 하고(세션해제) -> index.jsp를 응답
		} else if (cmd.equals("login")) {
			// 회원로그인 페이지로 이동
		} else if (cmd.equals("loginProc")) {
			// 회원 로그인을 진행 한 후 -> 세션에 등록을 한 후 -> index.jsp를 응답
		}
		return null;
	}

}