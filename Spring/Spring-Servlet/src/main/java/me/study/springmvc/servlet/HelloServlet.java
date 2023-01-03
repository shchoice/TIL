package me.study.springmvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
  @Override
  public void init() throws ServletException {
    System.out.println("init");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doGet");
    resp.getWriter().println("<h1>Hello " + getName() + "</h1>");
    // 1. 톰캣 기동 시
    // Context Initialized
    // Filter Init
    // 2. 첫번째 요청 시(http://localhost:8080/hello)
    // init
    // Filter
    // doGet
    // 3.두번째 요청 시
    // Filter
    // doGet
    // 4. 톰캣 서버 종료 시
    // destory
    // Filter Destory
    // Context Destroyed
  }

  private Object getName() {
    return getServletContext().getAttribute("name");
  }

  @Override
  public void destroy() {
    System.out.println("destroy");
  }
}
