package phuocvu.org.btl_web_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import phuocvu.org.btl_web_final.dao.AccountDAO;

import java.io.IOException;

@WebServlet(name = "UpdateAccount", value = "/UpdateAccount")
public class UpdateAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy accountId của tài khoản cần sửa từ request
        int accountId = Integer.parseInt(request.getParameter("id"));

        // Forward request và response đến trang editAccount.jsp với accountId
        request.setAttribute("accountId", accountId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editAccount.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin tài khoản cần chỉnh sửa từ request
        int accountId = Integer.parseInt(request.getParameter("id"));
        String user = request.getParameter("user");
        int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
        int status = Integer.parseInt(request.getParameter("status"));

        // Gọi hàm chỉnh sửa tài khoản từ DAO
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.updateAccount(accountId, user, isAdmin, status);

        // Redirect về trang listAccounts.jsp sau khi chỉnh sửa thành công
        response.sendRedirect("listAccounts");
    }
}
