/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import cart.ShoppingCart;
import entity.AuctionInfo;
import entity.BidDetails;
import entity.Product;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AuctionInfoFacade;
import session.CategoryFacade;
import session.ProductFacade;

/**
 *
 * @author Hoang Manh Hung
 */
public class ControllerServlet extends HttpServlet {

    private String surcharge;
    
    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private ProductFacade productFacade;
    @EJB
    private AuctionInfoFacade auctionInfoFacade;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

        // store category list in servlet context
        //getServletContext().setAttribute("categories", categoryFacade.findAll());
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        BidDetails bidDetails = (BidDetails)session.getAttribute("bidDetails");
        AuctionInfo auctionInfo = (AuctionInfo)session.getAttribute("auctionInfo");

        try {
            productFacade = (ProductFacade)new InitialContext().lookup("java:Module/productFacade");
            auctionInfoFacade = (AuctionInfoFacade)new InitialContext().lookup("java:Module/auctionInfoFacade");
            int carId = Integer.parseInt(request.getParameter("catId"));

            Product p = productFacade.find(request.getParameter("productId"));
            System.out.println("old: " + p.getPrice());
            AuctionInfo ai = auctionInfoFacade.find(p);
            p.setPrice(p.getPrice() + 5);
            System.out.println("new: " + p.getPrice());
            productFacade.edit(p);
            
            /*Double highestBid = (Double)session.getAttribute("highestBid");
            highestBid += 5;
            session.setAttribute("auctionInfo", highestBid);*/
            response.sendRedirect("/OAS/view/auction.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}