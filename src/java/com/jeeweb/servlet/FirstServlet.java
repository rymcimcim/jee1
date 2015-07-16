package com.jeeweb.servlet;

import com.jeeweb.entity.User;
import com.jeeweb.storage.Storage;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {

    private String imie, nazwisko, email1, email2;

    private User user;
    private static Integer registeredUsers;
    private static Storage storage;
    private static final Integer MAX_USERS = 2;
    private boolean isUser;

    public FirstServlet() {
        super();
        storage = new Storage();
        registeredUsers = storage.getUsers().size();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkFields(request, response);
        if (isUser) {
            checkEmail(request, response);
            noAccess(request, response);
            overload(request, response);
            register(request, response);
        }
    }

    private void checkFields(HttpServletRequest request, HttpServletResponse response) {
        isUser = true;
        imie = (String) request.getParameter("imie");
        nazwisko = (String) request.getParameter("nazwisko");
        email1 = (String) request.getParameter("email1");
        email2 = (String) request.getParameter("email2");
        String[] s = new String[]{imie, nazwisko, email1, email2};
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null || s[i].trim().length() == 0 || s[i].isEmpty() || "".equals(s[i])) {
                try {
                    response.sendRedirect("emptyFields.jsp");
                } catch (IOException e) {
                }
                isUser = false;
                break;
            }
        }
    }

    private void checkEmail(HttpServletRequest request, HttpServletResponse response) {
        if (!email1.equals(email2)) {
            try {
                response.sendRedirect("wrongMail.jsp");
            } catch (IOException e) {
            }
        }
    }

    private void noAccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (isRegistered(session)) {
            try {
                response.sendRedirect("noAccess.jsp");
            } catch (IOException e) {
            }
        }
    }

    private void overload(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        if (isOverloaded(context)) {
            try {
                response.sendRedirect("overload.jsp");
            } catch (IOException e) {
            }
        }
    }

    private boolean isOverloaded(ServletContext context) {
        if (context.getAttribute("registeredUsers") == null) {
            context.setAttribute("registeredUsers", 0);
            System.out.println("regUsersCheck:" + (Integer) context.getAttribute("registeredUsers"));
            return false;
        }
        System.out.println("regUsersEndCheck:" + (Integer) context.getAttribute("registeredUsers"));
        return (Integer) context.getAttribute("registeredUsers") >= MAX_USERS;
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {

        imie = request.getParameter("imie");
        nazwisko = request.getParameter("nazwisko");
        email1 = request.getParameter("email1");
        email2 = request.getParameter("email2");
        String firma = request.getParameter("firma");
        String from = request.getParameter("from");
        String other = request.getParameter("other");
        String pozycja = request.getParameter("pozycja");

        user = new User(imie, nazwisko, email1, email2, firma, from, other, pozycja);

        storage.getUsers().put(imie, user);
        try {
            response.getWriter().println(user);
        } catch (IOException e) {
        }

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        session.setAttribute("user", user);
        if ((Integer) context.getAttribute("registeredUsers") < MAX_USERS) {
            registeredUsers = storage.getUsers().size();
            context.setAttribute("registeredUsers", registeredUsers);
        }
        System.out.println("regUsersEND:" + (Integer) context.getAttribute("registeredUsers"));
    }

    private boolean isRegistered(HttpSession session) {
        return session.getAttribute("user") != null;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
