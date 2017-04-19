package com.netcracker.kutz;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Егор on 12.04.17.
 */

//todo
public class Controller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        handleRequest(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        handleRequest(httpServletRequest,httpServletResponse);
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response){

        Command command = new Command();

        try {
            String page = command.handle(request,response);
            RequestDispatcher view = request.getRequestDispatcher(page);
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
