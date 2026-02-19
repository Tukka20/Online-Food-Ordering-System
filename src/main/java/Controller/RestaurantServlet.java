package Controller;

import dao.RestaurantDao;
import entity.Restaurants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RestaurantDao restaurantDao=new RestaurantDao();

        try {
            List<Restaurants> restaurants=restaurantDao.getRestaurantList();

            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();


            //html for restaurant
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Restaurants</title>");

            out.println("<link href='https://fonts.googleapis.com/css2?family=Pacifico&family=Roboto:wght@400;700&display=swap' rel='stylesheet'>");

            out.println("<style>");
            out.println("body {");
            out.println("margin:0;");
            out.println("padding:0;");
            out.println("font-family: 'Roboto', sans-serif;");
            out.println("background: url(\"Photos/restuarent.jpg\") no-repeat center fixed;");
            out.println("background-size: cover;");
            out.println("color:white;");
            out.println("text-align:center;");
            out.println("}");

            out.println(".overlay {");
            out.println("background: rgba(0,0,0,0.7);");
            out.println("min-height:100vh;");
            out.println("padding:40px;");
            out.println("}");

            out.println("h2 {");
            out.println("font-family: 'Pacifico', cursive;");
            out.println("font-size:3rem;");
            out.println("color:#FFD93D;");
            out.println("}");

            out.println(".card {");
            out.println("background: rgba(255, 255, 255, 0.15);");
            out.println("backdrop-filter: blur(12px);");        // Glass blur
            out.println("-webkit-backdrop-filter: blur(12px);");
            out.println("border: 1px solid rgba(255,255,255,0.3);");
            out.println("margin:20px auto;");
            out.println("padding:20px;");
            out.println("width:320px;");
            out.println("border-radius:15px;");
            out.println("box-shadow: 0 8px 32px rgba(0,0,0,0.5);");
            out.println("transition:0.3s ease;");
            out.println("}");


            out.println(".card:hover {");
            out.println("transform: scale(1.07);");
            out.println("background: rgba(255, 255, 255, 0.25);");
            out.println("box-shadow: 0 12px 40px rgba(0,0,0,0.7);");
            out.println("}");


            out.println("a {");
            out.println("text-decoration:none;");
            out.println("color:white;");
            out.println("font-size:1.6rem;");
            out.println("font-weight:bold;");
            out.println("}");


            out.println(".logout {");
            out.println("display:inline-block;");
            out.println("margin-top:30px;");
            out.println("padding:10px 20px;");
            out.println("background: linear-gradient(90deg,#FF6B6B,#FFD93D,#6BCB77,#4D96FF);");
            out.println("border-radius:6px;");
            out.println("}");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='overlay'>");
            out.println("<h2>Available Restaurants</h2>");

            for (Restaurants r : restaurants) {
                out.println("<div class='card'>");
                out.println("<a href='menu?restaurantId=" + r.getId() + "'>");
                out.println(r.getName());
                out.println("</a>");
                out.println("</div>");
            }

            out.println("<br>");
            out.println("<a class='logout' href='logout'>Logout</a>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");



        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

