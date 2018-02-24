/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DR Gamal
 */
@WebServlet(urlPatterns = {"/JSONChatServlet"})
public class JSONChatServlet extends HttpServlet {
    
    Vector<User> users = JSONServlet.getUsers();
    static Vector<MessageDTO> messages = new Vector<MessageDTO>();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        MessageDTO msgtodo = new MessageDTO();
        String message = request.getParameter("msg");
        System.out.println(message);
        String name;
        name = (String) request.getSession(false).getAttribute("username");
        System.out.println(name);
        PrintWriter out = response.getWriter();
      
        
        for (User user : users)
            {
                 if(user.getName().equals(name)){
                   msgtodo.setName(name);
                   msgtodo.setMessage(message);
                   messages.add(msgtodo);
                 }
            }
         response.setContentType("application/json");
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(messages.get(messages.size() - 1)));
        response.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(messages));
        response.getWriter().close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
