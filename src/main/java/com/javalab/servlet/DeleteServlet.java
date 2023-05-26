

package com.javalab.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalab.dao.MemberDAO;
/*
	회원정보를 업데이트하는 서블릿
*/
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	
private static final long serialVersionUID = -7539512086856524299L;

	protected void doGet(HttpServletRequest request, 
                  HttpServletResponse response)
                  throws ServletException, IOException {
			doHandle(request, response);
			
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException {
			doHandle(request, response);
		
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		  // 1. 사용자가 입력한 한글정보의 인코딩 처리
	      request.setCharacterEncoding("utf-8");
	      
	      // 2. 사용자에게 보낼 컨텐츠의 인코딩 처리
	      response.setContentType("text/html;charset=utf-8");
	      
	      // 3. 데이터베이스 핸들링 담당 객체 생성
	      MemberDAO dao = new MemberDAO();
	      
	      // 4. 파라미터 수집
	      String id = request.getParameter("id");
	      
	      // 5. 삭제 메소드 호출
	      dao.deleteMember(id);
	      
	      String contextPath = request.getContextPath();
	      
	      // 7. 삭제, 작업 후에 회원 조회 리스트 보여줌
	      response.sendRedirect(contextPath + "/list");
	   }
	}
