package Controller;

import dao.MenuDao;
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

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        HttpSession session=req.getSession();
        session.setAttribute("restaurantId",restaurantId);

        MenuDao dao = new MenuDao();
        List<Menu> items = null;
        try {
            items = dao.getMenu(restaurantId);


        PrintWriter out = resp.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menu</title>");

            out.println("<link href='https://fonts.googleapis.com/css2?family=Pacifico&family=Roboto:wght@400;700&display=swap' rel='stylesheet'>");

            out.println("<style>");

            if(restaurantId==1)
            {
                out.println("body {");
                out.println("margin:0;");
                out.println("padding:0;");
                out.println("font-family: 'Roboto', sans-serif;");
                out.println("background: url(\"Photos/dominos.jpg\") no-repeat center fixed;");
                out.println("background-size: cover;");
                out.println("}");
            } else
                if (restaurantId==2)
                {
                    out.println("body {");
                    out.println("margin:0;");
                    out.println("padding:0;");
                    out.println("font-family: 'Roboto', sans-serif;");
                    out.println("background: url(\"Photos/kfc.jpg\") no-repeat center fixed;");
                    out.println("background-size: cover;");
                    out.println("}");
                }
                else
                {
                    out.println("body {");
                    out.println("margin:0;");
                    out.println("padding:0;");
                    out.println("font-family: 'Roboto', sans-serif;");
                    out.println("background: url(\"Photos/burger king.jpg\") no-repeat center fixed;");
                    out.println("background-size: cover;");
                    out.println("}");

                }


            out.println(".overlay {");
            out.println("background: rgba(0,0,0,0.7);");
            out.println("min-height:100vh;");
            out.println("padding:40px;");
            out.println("text-align:center;");
            out.println("}");

            out.println("h2 {");
            out.println("font-family: 'Pacifico', cursive;");
            out.println("font-size:3rem;");
            out.println("color:#FFD93D;");
            out.println("margin-bottom:40px;");
            out.println("}");

            /* Grid Layout */
            out.println(".menu-container {");
            out.println("display: grid;");
            out.println("grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));");
            out.println("gap: 25px;");
            out.println("max-width: 1100px;");
            out.println("margin: auto;");
            out.println("}");

            /* Card Design */
            out.println(".card {");
            out.println("background: white;");
            out.println("color: #333;");
            out.println("padding: 25px;");
            out.println("border-radius: 12px;");
            out.println("box-shadow: 0 10px 25px rgba(0,0,0,0.4);");
            out.println("border-left: 6px solid #FFD93D;");
            out.println("transition: 0.3s ease;");
            out.println("text-align:left;");
            out.println("}");

            out.println(".card:hover {");
            out.println("transform: translateY(-8px);");
            out.println("box-shadow: 0 15px 35px rgba(0,0,0,0.6);");
            out.println("}");

            out.println(".card h3 {");
            out.println("margin:0;");
            out.println("font-size:1.4rem;");
            out.println("}");

            out.println(".price {");
            out.println("color: #FF6B6B;");
            out.println("font-weight: bold;");
            out.println("font-size: 1.2rem;");
            out.println("margin-top: 10px;");
            out.println("}");

            out.println("button {");
            out.println("margin-top: 15px;");
            out.println("padding: 10px 20px;");
            out.println("border: none;");
            out.println("border-radius: 8px;");
            out.println("font-weight: bold;");
            out.println("cursor: pointer;");
            out.println("background: #4D96FF;");
            out.println("color: white;");
            out.println("transition: 0.3s;");
            out.println("}");

            out.println("button:hover {");
            out.println("background: #1f6fe5;");
            out.println("}");

            out.println(".nav-links {");
            out.println("margin-top:40px;");
            out.println("}");

            out.println(".nav-links a {");
            out.println("display:inline-block;");
            out.println("margin:10px;");
            out.println("padding:10px 20px;");
            out.println("background:#FFD93D;");
            out.println("color:black;");
            out.println("text-decoration:none;");
            out.println("font-weight:bold;");
            out.println("border-radius:6px;");
            out.println("transition:0.3s;");
            out.println("}");

            out.println(".nav-links a:hover {");
            out.println("background:#FFC300;");
            out.println("}");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='overlay'>");
            out.println("<h2>Menu</h2>");

            out.println("<div class='menu-container'>");

            for (Menu item : items) {

                out.println("<div class='card'>");

                out.println("<h3>" + item.getName() + "</h3>");
                out.println("<p class='price'>$ " + item.getPrice() + "</p>");

                out.println("<form action='cart' method='post'>");
                out.println("<input type='hidden' name='name' value='" + item.getName() + "'>");
                out.println("<input type='hidden' name='price' value='" + item.getPrice() + "'>");
                out.println("<button type='submit'>Add to Cart</button>");
                out.println("</form>");

                out.println("</div>");
            }

            out.println("</div>");  // close menu-container

            out.println("<div class='nav-links'>");
            out.println("<a href='restaurant'>Back to Restaurant</a>");
            out.println("<a href='cart'>View Cart</a>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</div>");

            out.println("</div>");  // close overlay
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
