package phuocvu.org.btl_web_final.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phuocvu.org.btl_web_final.dao.CategoryDAO;
import phuocvu.org.btl_web_final.dao.ProductDAO;
import phuocvu.org.btl_web_final.entity.Category;
import phuocvu.org.btl_web_final.entity.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String cateID = request.getParameter("cid");

        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> productList = productDAO.getProductByCID(cateID);
        List<Category> categoryList = categoryDAO.getAllCategory();
        Product productLast = productDAO.getLast();

        request.setAttribute("product_list", productList);
        request.setAttribute("category_list", categoryList);
        request.setAttribute("p", productLast);
        request.setAttribute("tag", cateID);

        request.getRequestDispatcher("/Home.jsp").forward(request, response);
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
