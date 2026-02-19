package Controller;

import entity.Menu;
import entity.Restaurants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {


    ///add item to cart
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        List<Menu> cart=(List<Menu>)session.getAttribute("cart");
        if(cart==null)
        {
            cart=new ArrayList<>();
        }
        String foodName=req.getParameter("name");
        int price=Integer.parseInt(req.getParameter("price"));
        cart.add(new Menu(foodName,price));
        session.setAttribute("cart",cart);
        resp.sendRedirect("cart");

    }


    //view cart
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer restaurantId=(Integer) session.getAttribute("restaurantId");

        PrintWriter out=resp.getWriter();

        List<Menu> cart=(List<Menu>)session.getAttribute("cart");
        int total=0;
        resp.setContentType("text/html");


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cart</title>");

        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap' rel='stylesheet'>");

        out.println("<style>");

        out.println("body {");
        out.println("margin:0;");
        out.println("padding:0;");
        out.println("font-family:'Poppins', sans-serif;");
        out.println("background: url(\"Photos/index.jpg\") no-repeat center fixed;");
        out.println("background-size: cover;");
        out.println("}");

        out.println(".overlay {");
        out.println("background: rgba(0,0,0,0.75);");
        out.println("min-height:100vh;");
        out.println("padding:60px 20px;");
        out.println("text-align:center;");
        out.println("color:white;");
        out.println("}");

        out.println("h2 {");
        out.println("font-size:3rem;");
        out.println("color:#FFD93D;");
        out.println("margin-bottom:40px;");
        out.println("}");

        out.println(".cart-container {");
        out.println("max-width:900px;");
        out.println("margin:auto;");
        out.println("}");

        out.println(".cart-item {");
        out.println("background:white;");
        out.println("color:#333;");
        out.println("padding:25px;");
        out.println("margin-bottom:20px;");
        out.println("border-radius:12px;");
        out.println("display:flex;");
        out.println("justify-content:space-between;");
        out.println("align-items:center;");
        out.println("box-shadow:0 8px 20px rgba(0,0,0,0.4);");
        out.println("}");

        out.println(".item-name {");
        out.println("font-size:1.2rem;");
        out.println("font-weight:600;");
        out.println("}");

        out.println(".item-price {");
        out.println("font-size:1.1rem;");
        out.println("color:#FF6B6B;");
        out.println("font-weight:600;");
        out.println("}");

        out.println(".total-section {");
        out.println("margin-top:40px;");
        out.println("padding:25px;");
        out.println("background:rgba(255,255,255,0.1);");
        out.println("border-radius:12px;");
        out.println("}");

        out.println(".total-section h3 {");
        out.println("font-size:1.8rem;");
        out.println("color:#FFD93D;");
        out.println("}");

        out.println(".btn-primary {");
        out.println("margin-top:20px;");
        out.println("padding:12px 30px;");
        out.println("border:none;");
        out.println("border-radius:8px;");
        out.println("font-weight:600;");
        out.println("cursor:pointer;");
        out.println("background:#4D96FF;");
        out.println("color:white;");
        out.println("transition:0.3s;");
        out.println("}");

        out.println(".btn-primary:hover {");
        out.println("background:#1f6fe5;");
        out.println("}");

        out.println(".nav-links {");
        out.println("margin-top:30px;");
        out.println("}");

        out.println(".nav-links a {");
        out.println("display:inline-block;");
        out.println("margin:10px;");
        out.println("padding:10px 20px;");
        out.println("background:#FFD93D;");
        out.println("color:black;");
        out.println("text-decoration:none;");
        out.println("font-weight:600;");
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
        out.println("<h2>Your Cart</h2>");
        out.println("<div class='cart-container'>");

        if (cart != null && !cart.isEmpty()) {

            for (Menu item : cart) {
                total += item.getPrice();

                out.println("<div class='cart-item'>");
                out.println("<div class='item-name'>" + item.getName() + "</div>");
                out.println("<div class='item-price'>$ " + item.getPrice() + "</div>");
                out.println("</div>");
            }

            out.println("<div class='total-section'>");
            out.println("<h3>Total Cart Value: $ " + total + "</h3>");

            out.println("<form action='order' method='post'>");
            out.println("<button class='btn-primary' type='submit'>Place Order</button>");
            out.println("</form>");

            out.println("</div>");

            out.println("<div class='nav-links'>");
            out.println("<a href='menu?restaurantId=" + restaurantId + "'>Back to Menu</a>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</div>");

        } else {

            out.println("<h3>Your cart is empty </h3>");
            out.println("<div class='nav-links'>");
            out.println("<a href='restaurant'>Back to Restaurant</a>");
            out.println("</div>");
        }

        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }


}
