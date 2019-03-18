package com.tg.member;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/auth/login")
public class memberLogin extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      RequestDispatcher rd = req.getRequestDispatcher("./LoginForm.jsp");
      rd.forward(req, res);      
      
   }
   
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "jsp";
      String password = "jsp";
      
      String email = req.getParameter("email");
      String pwd = req.getParameter("password");
      String name = "";
      
      
      String sql = "";
      int colIndex = 1; // 컬럼 위치
         
      
      try {
         
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
                  
         sql = "SELECT MNAME, EMAIL";
         sql += " FROM MEMBERS";
         sql += " WHERE EMAIL = ?";
         sql += " AND PWD = ?";
         
//         SELECT MNAME, EMAIL
//         FROM MEMBERS
//         WHERE EMAIL = 'S1@TEST.COM'
//         AND PWD = '1111';
                     
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(colIndex++, email);
         pstmt.setString(colIndex, pwd);
               
         rs = pstmt.executeQuery();
         System.out.println("쿼리 수행 성공");
         
//         res.setContentType("text/html");
//         res.setCharacterEncoding("UTF-8");
         
         if(rs.next()) {
            email = rs.getString("email");
            name = rs.getString("mname");
            
            MemberDto memberDto = new MemberDto();
            
            memberDto.setEmail(email);
            memberDto.setName(name);
            
            HttpSession session = req.getSession();
            session.setAttribute("member", memberDto);
                  
            res.sendRedirect("../member/list");
            
         }else {
        	  RequestDispatcher dispatcher =
                      req.getRequestDispatcher("./loginFail.jsp");
                
                dispatcher.forward(req, res);

         }
         
//         request 회원 목록 데이터 보관
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
//         e.printStackTrace();
         
         // 예외처리 페이지로 위엄
         req.setAttribute("error", e);
         RequestDispatcher dispatcher =
               req.getRequestDispatcher("/error.jsp");
         
         dispatcher.forward(req, res); //forwarding 방식(다른페이지로 위임하는 방식)
         
      }finally {
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
   
   
}