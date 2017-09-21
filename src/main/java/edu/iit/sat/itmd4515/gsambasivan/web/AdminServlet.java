/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.web;



import edu.iit.sat.itmd4515.gsambasivan.domain.Admins;
import edu.iit.sat.itmd4515.gsambasivan.ejb.AdminService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 *
 * @author Swathi
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(AdminServlet.class.getName());
    @EJB private AdminService adminService; 
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
        try{
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(request.isUserInRole("ADMIN_ROLE")){ 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath()+ "</h1>");
            
             Admins admin = adminService.findByUsername(request.getRemoteUser());
                out.println("<h2> Logged in as: " +admin.getUser().getUserName() + "</h2>" );
                
                out.println("<ul>");
                out.println("<li> Admin First Name: " +admin.getFirstName()+ "</li>");
                out.println("<li> Admin Last Name: " +admin.getLastName()+ "</li>");
                out.println("<li> Admin Designation : " +admin.getDesignation()+ "</li>");
                out.println("<li> Admin Store Location :" +admin.getStoreLocation()+ "</li>");
                out.println("<li> Admin Contact Email Address: " +admin.getEmail()+ "</li>");
                out.println("</ul>");
                
                out.println("<a href=\"" +request.getContextPath()+"/logout\">Logout</a>");
               out.println("</body>");
                out.println("</html>");
             }
             else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.html");
                requestDispatcher.forward(request, response);

            }
            
        }
        }
        catch (ServletException servletException) {
            LOGGER.log(Level.SEVERE, servletException.getMessage());
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage());
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
