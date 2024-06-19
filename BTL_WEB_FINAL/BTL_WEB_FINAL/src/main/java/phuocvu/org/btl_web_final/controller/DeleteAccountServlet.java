package phuocvu.org.btl_web_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import phuocvu.org.btl_web_final.dao.AccountDAO;

import java.io.IOException;

@WebServlet(name = "DeleteAccountServlet", value = "/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy accountId của tài khoản cần xóa từ request
        int accountId = Integer.parseInt(request.getParameter("id"));

        // Gọi hàm xóa tài khoản từ DAO
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.deleteAccount(accountId);

        // Redirect về trang listAccounts.jsp sau khi xóa thành công
        response.sendRedirect("listAccounts");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
