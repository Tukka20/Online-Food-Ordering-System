package Controller;

import dao.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao=new UserDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        try {
            UserDao.registration(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        PrintWriter out=resp.getWriter();
        out.println("Registration Successfully!!");
        resp.sendRedirect("login.html");
    }
}
