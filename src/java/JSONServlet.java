/*
 * To change this license header, choose License Headers in Project Properties.
- * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author DR Gamal
 */
@WebServlet(urlPatterns = {"/JSONServlet"})
public class JSONServlet extends HttpServlet {
    
    static Vector<User> users = new Vector<User>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            User user = new User();
            PrintWriter out = response.getWriter();
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            user.setName(name);
            user.setPassword(password);
            users.add(user);
            System.out.println("Sign up servlet : "+ name+ " " + password);
            
}

    public static Vector<User> getUsers() {
        return users;
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
