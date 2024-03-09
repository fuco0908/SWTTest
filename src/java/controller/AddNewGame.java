/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.GamePopularDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GameDetail;

/**
 *
 * @author thanh
 */
@WebServlet(name = "AddNewGame", urlPatterns = {"/AddNewGame"})
public class AddNewGame extends HttpServlet {

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
        String gameID = request.getParameter("gameID");
        int GameID = Integer.parseInt(gameID);
        String GameName = request.getParameter("gameName");
        String GameGenre = request.getParameter("gameGenre");
        String Publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        float Price = Float.parseFloat(price);
        String Description = request.getParameter("description");
        String OS = request.getParameter("os");
        String Processor = request.getParameter("processor");
        String Memory = request.getParameter("memory");
        String Graphics = request.getParameter("graphics");
        String DirectX = request.getParameter("dX");
        String Network = request.getParameter("network");
        String Storage = request.getParameter("storage");
        String ReleaseDay = request.getParameter("releaseDay");
        String image1 = request.getParameter("img1");
        String image2 = request.getParameter("img2");
        String image3 = request.getParameter("img3");
        String image4 = request.getParameter("img4");
        String link = request.getParameter("link");
        //CODE GAME
//        String CodeID = request.getParameter("codeID");
//        String Code = request.getParameter("code");
////        String Status = request.getParameter("status");
//        if ((gameID != null) && (GameName != null) && (GameGenre != null)
//                && (Publisher != null) && (price != null) && (Description != null)
//                && (OS != null) && (Processor != null) && (Memory != null)
//                && (Graphics != null) && (DirectX != null) && (Network != null)
//                && (Storage != null) && (ReleaseDay != null)) {
    

        GamePopularDAO c = new GamePopularDAO();
        GameDetail check = c.checkGameID(GameID);
        if (check == null) {
            GameDetail g = new GameDetail(GameID, GameName, GameGenre, Publisher, Price, Description, OS, Processor, Memory, Graphics, DirectX, Network, Storage, ReleaseDay);
            c.addNewGame(g);
            GameDetail img = new GameDetail(GameID, image1, image2, image3, image4, link);
            c.addNewGameImg(img);

            //c.addNewGame2(GameID, GameName, GameGenre, Publisher, Price, Description, OS, Processor, Memory, Graphics, DirectX, Network, Storage, ReleaseDay);
            request.setAttribute("mess2", "success!");
            //response.sendRedirect("ControlGame.jsp");
            request.getRequestDispatcher("ControlGame.jsp").forward(request, response);

        } else {
            request.setAttribute("mess2", GameID + " was exist!");
            request.getRequestDispatcher("ControlGame.jsp").forward(request, response);
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
