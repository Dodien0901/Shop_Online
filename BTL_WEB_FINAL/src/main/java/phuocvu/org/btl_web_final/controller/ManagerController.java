package phuocvu.org.btl_web_final.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import phuocvu.org.btl_web_final.dao.CategoryDAO;
import phuocvu.org.btl_web_final.dao.ProductDAO;
import phuocvu.org.btl_web_final.entity.Account;
import phuocvu.org.btl_web_final.entity.Category;
import phuocvu.org.btl_web_final.entity.Product;


@WebServlet(name = "ManagerController", urlPatterns = {"/manager"})
public class ManagerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();

        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> productList = productDAO.getAllProduct();
        List<Category> categoryList = categoryDAO.getAllCategory();

        request.setAttribute("product_list", productList);
        request.setAttribute("category_list", categoryList);

        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
