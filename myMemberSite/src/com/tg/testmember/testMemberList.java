package com.tg.testmember;
import com.tg.member.*;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/testmember/tlist")
public class testMemberList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("MemberAddServlet의 doPost를 탄다");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		String sql = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
						
			sql = "SELECT MNO, MNAME, EMAIL,PWD, CRE_DATE";
			sql += " FROM MEMBERS";
			sql += " ORDER BY MNO ASC";
			
			pstmt = conn.prepareStatement(sql);
					
			rs = pstmt.executeQuery();//쿼리결과 담음
			
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			//request에 회원 목록 데이터 보관
			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
			
			int mno = 0;
			String mname = "";
			String email = "";
			String pwd="";
			Date creDate = null;
			MemberDto memberDto=null;
			while(rs.next()) {
				mno = rs.getInt("MNO");
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				pwd=rs.getString("PWD");
				creDate = rs.getDate("CRE_DATE");
				
				
				memberDto =new MemberDto(mno, mname, email,pwd ,creDate);
				memberList.add(memberDto);
				
			} // while end
			
			
			//* getAttribute, setAttribute 해당하는 요소의 속성 가져오고 설정하기
			req.setAttribute("memberList", memberList);
			
			//리다이렉트 처럼 다음 페이지를 지정할수있다
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/testMember/memberListView.jsp");
			
			//req와 res에 데이터를 포함하고 페이지 전환
			dispatcher.include(req, res);
			
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher= req.getRequestDispatcher("/error.jsp");
			dispatcher.forward(req, res);
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
	}
	
}
