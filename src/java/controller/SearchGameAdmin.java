/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import static com.microsoft.sqlserver.jdbc.StringUtils.isNumeric;
import dal.GamePopularDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.CodeGame;
import model.GameDetail;
import model.GamePopular;

/**
 *
 * @author thanh
 */
@WebServlet(name = "SearchGameAdmin", urlPatterns = {"/SearchGameAdmin"})
public class SearchGameAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String info = request.getParameter("gameSearch");
        GamePopularDAO dao = new GamePopularDAO();
        boolean isNumber = isNumeric(info);
        if (isNumber) {
            //int gameID = Integer.parseInt("info");
            GameDetail check = dao.checkGameID(Integer.parseInt(info));
            if (check != null) {      
                GameDetail g = dao.getGameByID(info);
                HttpSession session = request.getSession();               
                session.setAttribute("game", g);
                request.setAttribute("gameInfo", g);
                request.setAttribute("mess3", "game found!");
                request.getRequestDispatcher("SearchGameAdmin.jsp").forward(request, response);
            } else {
                request.setAttribute("mess3", "game was not exist!");
                request.getRequestDispatcher("SearchGameAdmin.jsp").forward(request, response);
            }

        } else {
            GameDetail check = dao.checkGameName(info);
            if (check != null) {
                GameDetail g = dao.getGameByName(info);
                HttpSession session = request.getSession();
                session.setAttribute("game", g);
                request.setAttribute("gameInfo", g);
                request.setAttribute("mess3", "game found!");
                request.getRequestDispatcher("SearchGameAdmin.jsp").forward(request, response);
            } else {
                request.setAttribute("mess3", "game was not exist!");
                request.getRequestDispatcher("SearchGameAdmin.jsp").forward(request, response);
            }
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
