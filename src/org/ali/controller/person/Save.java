package org.ali.controller.person;

import org.ali.model.common.exepts.EmptyField;
import org.ali.model.common.exepts.NotExceptLength;
import org.ali.model.common.exepts.NotNumber;
import org.ali.model.entity.Person;
import org.ali.model.service.PersonService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/person/save.do")
public class Save extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            if ( req.getParameter("name").length() == 0 ||
                    req.getParameter("age").length() == 0 || req.getParameter("family").length() == 0 ||
                    req.getParameter("nationalCode").length() == 0) {
                throw new EmptyField("fields are required..");
            }

            try {
                Long.parseLong(req.getParameter("nationalCode"));
            }catch(NumberFormatException e){
                throw new NotNumber("Age must be an integer");
            }

            if (req.getParameter("nationalCode").length() != 10) {
                throw new NotExceptLength("The national ID number consists of 10 digits.");
            }

            if (req.getParameter("name").length() >= 20) {
                throw new NotExceptLength("The name is too long.");
            }
            if (req.getParameter("family").length() >= 20) {
                throw new NotExceptLength("The family is too long.");
            }

            try {
                Integer.parseInt(req.getParameter("age"));
            }catch(Exception e){
                throw new NotNumber("Age must be an integer");
            }

            PersonService.getInstance().save(new Person(req.getParameter("name"),
                    req.getParameter("family"),
                    Integer.parseInt(req.getParameter("age")),req.getParameter("nationalCode")));

            res.sendRedirect(req.getContextPath()+"/person/findAll.do");
        }catch (Exception e){
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,res);
            e.printStackTrace();
        }
    }


}
