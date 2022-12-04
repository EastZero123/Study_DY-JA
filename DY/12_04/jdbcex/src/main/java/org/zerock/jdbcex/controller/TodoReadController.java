package org.zerock.jdbcex.controller;

import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            TodoDTO todoDTO = todoService.get(tno);

            req.setAttribute("dto", todoDTO);

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("read error");
        }
    }
}
