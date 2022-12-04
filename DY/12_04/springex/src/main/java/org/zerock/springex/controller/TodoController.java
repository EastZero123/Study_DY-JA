package org.zerock.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping("/list")
    public void list() {

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){

    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {

    }
}
