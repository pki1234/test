package lesson.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet {

	ServletConfig config;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//서블릿을 생성한후 초기화 작업을 수행하기 위해 호출하는 메서드
		//서블릿 클라이언트의 요청을 처리하기 위해 준비할 작업이 있다면
		//이 메서드에 작성해야 한다 필요한 자원을 미리준비
		//ex: 데이터베이스 연결됨
		System.out.println("init() 호출");
		this.config=config;
	}
	
	
	@Override
	public void destroy() {
		//서블릿 컨테이너가 종료되거나 웹 어플리케이션이 멈출때 ,
		//또는 해당 서블릿을 비활성화 시킬때 호출된다
		//따라서 이 메서드에는 서비스 수행을 위해 확보했던 자우너을
		//해제한다거나 데이터를 저장하는 등의 마무리 작업을 작성하면 된다.
		// TODO Auto-generated method stub
		System.out.println("destroy() 호출");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig() 호출");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo() 호출");
		return "서블릿 정보 돌려줌";
	}

	

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 호출");
	}

}
