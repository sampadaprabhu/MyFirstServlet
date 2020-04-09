import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/registrationServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Sampada"),
                @WebInitParam(name = "password", value = "adh@Sbns123")
        }
)
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        UserValidator userValidator = new UserValidator();

        if (userValidator.validateName(user) && userValidator.validatePassword(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>UserName Or Password Is Invalid!</font>");
            rd.include(request, response);
        }

    }
}
