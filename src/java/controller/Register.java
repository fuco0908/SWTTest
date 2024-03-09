/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.GamePopularDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GamePopular;
import model.SendEmail;
import model.User;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Register", urlPatterns = {"/register", "/verifycode"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    GamePopularDAO dao = new GamePopularDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("register")) {
            getRegister(request, response);
        } else if (url.contains("verifycode")) {
            request.getRequestDispatcher("VerifyCode.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("register")) {
            postRegister(request, response);
        } else if (url.contains("verifycode")) {
            postVerifyCode(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void getRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Registe.jsp").forward(request, response);
    }

    protected void postRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("user");
        String phone = request.getParameter("number");
        String email = request.getParameter("email");
        String passWord = request.getParameter("pwd");

        String alerMsg = "";
        if (dao.checkEmail(email)) {
            alerMsg = "Email đã tồn tại";
            request.setAttribute("mess", alerMsg);
            request.getRequestDispatcher("Registe.jsp").forward(request, response);
        } else if (dao.checkUserName(userName)) {
            alerMsg = "Tài khoản đã tồn tại";
            request.setAttribute("error", alerMsg);
            request.getRequestDispatcher("Registe.jsp").forward(request, response);
        } else {
            SendEmail sm = new SendEmail();
            String code = sm.getRandom();

            User user = new User(userName, email, phone, code);

            boolean test = sm.sendEmail(user);

            if (test) {
                HttpSession session = request.getSession();
                session.setAttribute("account", user);

                boolean isSuccess = dao.register(userName, passWord, email, phone, code);

                if (isSuccess) {
                    response.sendRedirect(request.getContextPath() + "/verifycode");
                } else {
                    alerMsg = "Lối Hệ Thống";
                    request.setAttribute("error", alerMsg);
                    request.getRequestDispatcher("Registe.jsp").forward(request, response);
                }
            } else {
                PrintWriter out = response.getWriter();
                out.println("Lỗi Khi gửi mail!!!");
            }
        }
    }

    protected void postVerifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("account");

            String code = request.getParameter("authcode");

            if (code.equals(user.getCode())) {
                user.setEmail(user.getEmail());
                user.setStatus(1);

                dao.updateStatus(user);

                out.println("<div class=\"container\"><br/>\r\n" + "        <br/>\r\n"
                        + "  <br/>Kich Hoat tai khoản thanh công!<br/>\r\n" + "<br/>\r\n"
                        + "   <br/></div>");
            } else {
                out.println("<div class=\"container\"><br/>\r\n" + "        <br/>\r\n"
                        + "  <br/>Sai mã Kich Hoat!<br/>\r\n" + "<br/>\r\n"
                        + "   <br/></div>");
            }

        } catch (Exception e) {
        }
    }

}
