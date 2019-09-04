package com.eeit109team6.servletmember;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.eeit109team6.memberDao.IMemberDao;
import com.eeit109team6.memberDao.Member;
import com.eeit109team6.memberDao.MemberDaoFactoery;


@WebServlet("/CheckMember")
public class CheckMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/team6project")
	private DataSource ds;
	Connection conn;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			conn = ds.getConnection();
			System.out.println("conn getConnection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int mber_id =Integer.parseInt(request.getParameter("id"));
		String token =request.getParameter("token");
		System.out.println("member_id="+mber_id);
		System.out.println("token="+token);
		Member mem = new Member();
		mem.setMember_id(mber_id);
		mem.setToken(token);
		System.out.println("==========================="+token.replaceAll("[\\pP\\p{Punct}]","").replace(" ", ""));
		
		try {
			IMemberDao MemDao = MemberDaoFactoery.createMember();
			boolean boo = MemDao.openActive(mem, conn);
			if(boo) {
				System.out.println("�w�}�q");
				response.getWriter().write("<script>alert('�w�}�q�еn�J�z���b��');document.location.href='http://localhost:8090/Member/html/LoginMember.html';</script>");
			}else {
				System.out.println("����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				System.out.println("Conn ����");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}




}
