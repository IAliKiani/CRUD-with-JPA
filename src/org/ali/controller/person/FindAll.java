package org.ali.controller.person;

import org.ali.model.entity.Person;
import org.ali.model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/person/findAll.do")
public class FindAll extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            List<Person> persons = PersonService.getInstance().selectAll();
            req.setAttribute("persons", persons);
            req.getRequestDispatcher("/person/all.jsp").forward(req, res);
        }catch (Exception e){
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,res);
        }
    }
}
