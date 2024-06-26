package my.study.springmvc;

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
    resp.getWriter().write("Hello " + getName());
  }

  private Object getName() {
    return getServletContext().getAttribute("name");
  }

  @Override
  public void destroy() {
    System.out.println("destroy");
  }
}
