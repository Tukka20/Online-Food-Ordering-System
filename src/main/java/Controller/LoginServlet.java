package Controller;

import dao.UserDao;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User(email, password);
            UserDao userDao = new UserDao();

        boolean valid = false;
        try {
            valid = userDao.login(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (valid) {
                HttpSession session = req.getSession();
                session.setAttribute("email", email);

                resp.sendRedirect("restaurant");
                return;
            }
            resp.sendRedirect("login.html");


    }





}

