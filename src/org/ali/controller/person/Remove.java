package org.ali.controller.person;

import org.ali.model.common.exepts.EmptyField;
import org.ali.model.common.exepts.NotExceptLength;
import org.ali.model.entity.Person;
import org.ali.model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/remove.do")
public class Remove extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {

            if (req.getParameter("id").length() == 0  || req.getParameter("version").length() == 0) {
                throw new EmptyField("fields are required..");
            }

            PersonService.getInstance().remove(new Person(Long.parseLong(req.getParameter("id")),
                    Integer.parseInt(req.getParameter("version"))));

            res.sendRedirect(req.getContextPath()+"/person/findAll.do");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,res);
        }
    }

}
