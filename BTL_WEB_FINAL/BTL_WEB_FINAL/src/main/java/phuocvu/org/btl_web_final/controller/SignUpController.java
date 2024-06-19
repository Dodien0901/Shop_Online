package phuocvu.org.btl_web_final.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phuocvu.org.btl_web_final.dao.AccountDAO;
import phuocvu.org.btl_web_final.entity.Account;


@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        if(!pass.equals(re_pass)){
            response.sendRedirect("Login.jsp");
        }else{
            AccountDAO accountDAO = new AccountDAO();
            Account a = accountDAO.checkAccountExist(user);
            if(a == null){
                //dc signup
                accountDAO.singup(user, pass);
                response.sendRedirect("home");
            }else{
                //day ve trang login.jsp
                response.sendRedirect("Login.jsp");
            }
        }
        //sign up
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
