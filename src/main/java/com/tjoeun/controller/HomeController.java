package com.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	브라우저의 주소창에 contextPath(/k20240215_2_mvcTest, 프로젝트 이름) 뒤에 @WebServlet 
//	어노테이션의 인수로 지정된 요청(/HomeController)이 들어오면 @WebServlet("/HomeController") 
//	어노테이션이 붙어있는 클래스(컨트롤러)에서 get 방식의 요청이 들어왔으면 doGet() 메소드가
// 	자동으로 실행되고 post 방식의 요청이 들어왔으면 doPost() 메소드가 자동으로 실행된다.
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

//	get 방식으로 요청이 들어오면 자동으로 실행되는 메소드 => submit 버튼이 클릭되지 않은 경우
//	주소창으로 전달되는 데이터가 goGet() 메소드 HttpServletRequest 인터페이스 객체에 저장된다. 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	System.out.println("get 방식으로 요청됨");
    	actionDo(request, response);
    }

//	post 방식으로 요청이 들어오면 자동으로 실행되는 메소드 => submit 버튼이 클릭된 경우
//	헤더에 담겨서 전달되는 데이터가 goPost() 메소드 HttpServletRequest 인터페이스 객체에 저장된다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("post 방식으로 요청됨");
		actionDo(request, response);
	}
	
//	get 방식으로 요청되던 post 방식으로 요청되던 HttpServletRequest 인터페이스 객체에 넘어오는
//	데이터가 저장되므로 doGet(), doPost() 메소드에서 actionDo() 메소드를 호출한다.
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("HomeController의 actionDo() 메소드 실행");	
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8"); // 받을 때
		response.setContentType("text/html; charset=UTF-8"); // 보낼 때
		
		// get 또는 post 방식으로 요청될 때 컨트롤러로 넘어오는 데이터를 받는다.
		String name = request.getParameter("name");
		System.out.println(name);
		
		// view 페이지로 전달할 데이터를 request 영역에 저장한다.
		request.setAttribute("name", name);
		
		// view 페이지 이름을 만든다.
		String viewpage = "/WEB-INF/hello.jsp";
		// RequestDispatcher 인터페이스 객체를 이용해서 요청에 따른 실제 view 페이지를 호출해서
		// 브라우저에 표시하기 위해 준비한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		// view 페이지를 호출한다.
		dispatcher.forward(request, response);
		
	}
}
