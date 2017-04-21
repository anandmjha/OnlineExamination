package com.onlineExamination.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineExamination.beans.Member;
import com.onlineExamination.dao.MemberDao;
import com.onlineExamination.dao.MemberDaoImp;
import com.onlineExamination.dao.QestionSetDaoImp;
import com.onlineExamination.dao.QuestionSetDao;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDao md = new MemberDaoImp();
	Member mb = new Member();

	@Override
	public void init() throws ServletException {
 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession hs = request.getSession();
		System.out.println("in controller");
		if (request.getParameter("action").equals("Register")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String type = request.getParameter("type");
			String password = request.getParameter("password");
			System.out.println("type = "+type);
			if(md.RegisterUser(email, name, type, password)==1){
				Member member = md.getMemberData(email);
				hs.setAttribute("member", member);
				request.getSession().setAttribute("username", email);
				rd = request.getRequestDispatcher("userdashboard.jsp");
			}else if(md.RegisterUser(email, name, type, password)==2){
				rd = request.getRequestDispatcher("existinguser.jsp");
			}else 
				rd = request.getRequestDispatcher("loginerror.jsp");
			rd.forward(request, response);
			 
		}

		else if (request.getParameter("action").equals("Login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String memberType = null;
			System.out.println("In Login");
			System.out.println("working");
			if (md.validateMember(username, password)) {
				Member member = md.getMemberData(username);
				hs.setAttribute("member", member);
				memberType = mb.getType();
				System.out.println(mb.getType());
				hs.setAttribute("memberType", memberType);
				System.out.println(memberType);
				if (member.getType().equalsIgnoreCase("candidate")) {
					request.getSession().setAttribute("username", username);
					rd = request.getRequestDispatcher("userdashboard.jsp");
				} else if (member.getType().equalsIgnoreCase("reviewer")) {
					request.getSession().setAttribute("username", username);
					rd = request.getRequestDispatcher("examinerdashboard.jsp");
				} else if (member.getType().equalsIgnoreCase("paperSetter")) {
					request.getSession().setAttribute("username", username);
					rd = request.getRequestDispatcher("examinerdashboard.jsp");
				}
			} else
				rd = request.getRequestDispatcher("loginerror.jsp");
			rd.forward(request, response);
		}

	}
}
