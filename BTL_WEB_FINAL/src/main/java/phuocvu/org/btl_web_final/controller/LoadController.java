package phuocvu.org.btl_web_final.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phuocvu.org.btl_web_final.dao.CategoryDAO;
import phuocvu.org.btl_web_final.dao.ProductDAO;
import phuocvu.org.btl_web_final.entity.Category;
import phuocvu.org.btl_web_final.entity.Product;

import java.util.List;
@WebServlet(name = "LoadController", urlPatterns = {"/loadProduct"})

public class LoadController extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");

        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        Product p = productDAO.getProductByID(id);
        List<Category> categoryList = categoryDAO.getAllCategory();

        request.setAttribute("detail", p);
        request.setAttribute("listCC", categoryList);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
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
