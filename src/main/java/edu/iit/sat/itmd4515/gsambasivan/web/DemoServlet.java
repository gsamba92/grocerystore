/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.web;

import edu.iit.sat.itmd4515.gsambasivan.domain.ProductCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.validation.Validator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

/**
 *
 * @author Swathi
 */
@WebServlet(name = "DemoServlet", urlPatterns = {"/demo"})
public class DemoServlet extends HttpServlet {

    
    private static final Logger LOG = Logger.getLogger(DemoServlet.class.getName());
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager entityManager;

    @Resource
   private Validator validator;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DemoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
          // processRequest(request, response);
           
           ProductCategory c = buildProductCategoryFromRequestParams(request);    
           if(c==null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
           dispatcher.forward(request, response);
        }
           else{
           request.setAttribute("ProductCategory", c);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
           dispatcher.forward(request, response);
           }
       } catch (ParseException ex) {
           Logger.getLogger(DemoServlet.class.getName()).log(Level.SEVERE, null, ex);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
           dispatcher.forward(request, response);
       }
    }
private ProductCategory buildProductCategoryFromRequestParams(HttpServletRequest request) throws ParseException{
     
    
       String categoryName = request.getParameter("categoryName");
       String description=request.getParameter("description");           
      if(categoryName == "" || description==""){
      categoryName = null;description = null;
      }   
       ProductCategory c = new ProductCategory(categoryName, description);
       
       // after constructing the object, we should validate
       // and the easiest way to do that, is with a Validator
       Set<ConstraintViolation<ProductCategory>> violations = validator.validate(c);
       if(violations.isEmpty()){
           LOG.info(c.toString());
           return c;
       } else {
            LOG.info(c.toString());
           // log the errors from validation
           // return validation errors to the user for further input (to fix them)
           return null;
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

}
