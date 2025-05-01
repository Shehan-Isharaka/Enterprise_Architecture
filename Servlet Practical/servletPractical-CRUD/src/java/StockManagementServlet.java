/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(urlPatterns = {"/StockManagementServlet"})
public class StockManagementServlet extends HttpServlet {

    private Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new SQLException("MySQL JDBC Driver not found", e);
    }
    String url = "jdbc:mysql://localhost:3306/stock_management";
    String username = "root";
    String password = "";
    return DriverManager.getConnection(url, username, password);
}


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

        String action = request.getParameter("action");
        String productName = request.getParameter("product_name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            

           try (Connection conn = getConnection()) {
            switch (action) {

                case "Add Product":
                    try (PreparedStatement stmt = conn.prepareStatement(
                            "INSERT INTO stock(product_name, quantity) VALUES (?, ?)")) {
                        stmt.setString(1, productName);
                        stmt.setInt(2, quantity);
                        stmt.executeUpdate();
                        response.getWriter().write("<h1>Product Added Successfully</h1>");
                    }
                    break;

                case "Update Product":
                    try (PreparedStatement stmt = conn.prepareStatement(
                            "UPDATE stock SET quantity = ? WHERE product_name = ?")) {
                        stmt.setInt(1, quantity);
                        stmt.setString(2, productName);
                        stmt.executeUpdate();
                        response.getWriter().write("<h1>Product Updated Successfully</h1>");
                    }
                    break;

                case "Delete Product":
                    try (PreparedStatement stmt = conn.prepareStatement(
                            "DELETE FROM stock WHERE product_name = ?")) {
                        stmt.setString(1, productName);
                        stmt.executeUpdate();
                        response.getWriter().write("<h1>Product Deleted Successfully</h1>");
                    }
                    break;

                default:
                    response.getWriter().write("<h1>Invalid Action</h1>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("<h1>Database Error: " + e.getMessage() + "</h1>");
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
