//package phuocvu.org.btl_web_final.controller;
//
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import phuocvu.org.btl_web_final.entity.Cart;
//import phuocvu.org.btl_web_final.entity.LineItem;
//import phuocvu.org.btl_web_final.entity.Product;
//
//import java.io.IOException;
//
//public class CartController extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String url = "/index.jsp";
//        ServletContext sc = getServletContext();
//
//        // get current action
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "cart";  // default action
//        }
//
//        // perform action and set URL to appropriate page
//        if (action.equals("shop")) {
//            url = "/index.jsp";    // the "index" page
//        }
//        else if (action.equals("cart")) {
//            String productCode = request.getParameter("productCode");
//            String quantityString = request.getParameter("quantity");
//
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//            }
//
//            //if the user enters a negative or invalid quantity,
//            //the quantity is automatically reset to 1.
//            int quantity;
//            try {
//                quantity = Integer.parseInt(quantityString);
//                if (quantity < 0) {
//                    quantity = 1;
//                }
//            } catch (NumberFormatException nfe) {
//                quantity = 1;
//            }
//
//            String path = sc.getRealPath("/WEB-INF/products.txt");
//            Product product = ProductIO.getProduct(productCode, path);
//
//            LineItem lineItem = new LineItem();
//            lineItem.setProduct(product);
//            lineItem.setQuantity(quantity);
//            if (quantity > 0) {
//                cart.addItem(lineItem);
//            } else if (quantity == 0) {
//                cart.removeItem(lineItem);
//            }
//
//            session.setAttribute("cart", cart);
//            url = "/cart.jsp";
//        }
//        else if (action.equals("checkout")) {
//            url = "/checkout.jsp";
//        }
//
//        sc.getRequestDispatcher(url)
//                .forward(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response)
//            throws ServletException, IOException {
//        doPost(request, response);
//    }
//}