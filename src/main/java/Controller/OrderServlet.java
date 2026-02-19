package Controller;

import dao.OrderDao;
import entity.Menu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        HttpSession session = req.getSession();
        String email=(String)session.getAttribute("email");
        List<Menu> cart=(List<Menu>) session.getAttribute("cart");
        resp.setContentType("text/html");


        out.println("<!DOCTYPE html>");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Order Success</title>");

        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap' rel='stylesheet'>");

        out.println("<style>");

        out.println("body {");
        out.println("margin:0;");
        out.println("padding:0;");
        out.println("font-family:'Poppins', sans-serif;");
        out.println("background: url(\"Photos/index.jpg\") no-repeat center fixed;");
        out.println("background-size: cover;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("height:100vh;");
        out.println("}");

        out.println(".overlay {");
        out.println("background: rgba(0,0,0,0.75);");
        out.println("padding:50px;");
        out.println("border-radius:15px;");
        out.println("text-align:center;");
        out.println("color:white;");
        out.println("width:400px;");
        out.println("box-shadow:0 10px 30px rgba(0,0,0,0.6);");
        out.println("}");

        out.println(".success-icon {");
        out.println("font-size:60px;");
        out.println("color:#4CAF50;");
        out.println("margin-bottom:20px;");
        out.println("}");

        out.println("h2 {");
        out.println("margin-bottom:20px;");
        out.println("color:#FFD93D;");
        out.println("}");

        out.println(".btn {");
        out.println("display:inline-block;");
        out.println("margin:10px;");
        out.println("padding:10px 20px;");
        out.println("border-radius:8px;");
        out.println("text-decoration:none;");
        out.println("font-weight:600;");
        out.println("}");

        out.println(".btn-primary {");
        out.println("background:#4D96FF;");
        out.println("color:white;");
        out.println("}");

        out.println(".btn-primary:hover {");
        out.println("background:#1f6fe5;");
        out.println("}");

        out.println(".btn-secondary {");
        out.println("background:#FFD93D;");
        out.println("color:black;");
        out.println("}");

        out.println(".btn-secondary:hover {");
        out.println("background:#FFC300;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        try {
            if (email !=null)
            {
                OrderDao order = new OrderDao();
                order.placeOrder(email, cart);
                session.removeAttribute("cart");

                out.println("<div class='overlay'>");
                out.println("<div class='success-icon'>✔</div>");
                out.println("<h2>Order Placed Successfully!</h2>");
                out.println("<p>Thank you for ordering with us.</p>");

                out.println("<a class='btn btn-primary' href='restaurant'>Order Again</a>");
                out.println("<a class='btn btn-secondary' href='logout'>Logout</a>");
                out.println("</div>");



            }
            else
                resp.sendRedirect("login.html");
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}

