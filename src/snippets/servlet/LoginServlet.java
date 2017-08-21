package snippets.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected String createForm (String errMsg) {
        StringBuilder stringBuilder = new StringBuilder("<html><head><link rel='stylesheet' type='text/css' href='static/css/index.css'></head><body><h2>Login</h2>");
        //check whether error message is to be displayed
        if (errMsg != null) {
            stringBuilder.append("<span style='color: red'>")
                .append(errMsg)
                .append("</span>");
        }
        //create form
        stringBuilder.append("<form method='post'>\n")
            .append("User Name: <input type='text' name='userName' class='a-input-text a-span12'>\n")
            .append("Password: <input type='password' name='password' class='a-input-text a-span12'>\n")
            .append("<button type='submit' name='submit'>Submit</button>\n")
            .append("<button type='reset'>Reset</botton>\n")
            .append("</form>")
            .append("</body>")
            .append("</html>");
        return stringBuilder.toString();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        response.getWriter().write(createForm(null));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //create StringBuilder to hold response string
        StringBuilder stringBuilder = new StringBuilder();
        if ("admin".equals(userName) && "admin".equals(password)) {
            stringBuilder.append("<h2>Welcom admin !</h2>")
                .append("You are sucessfully logged in");
        } else {
            stringBuilder.append(createForm("Invalid user id or password. Please try again"));
        }
        response.setContentType("text/html");
        response.getWriter().write(stringBuilder.toString());
    }

}
