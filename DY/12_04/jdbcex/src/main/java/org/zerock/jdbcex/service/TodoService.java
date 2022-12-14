package org.zerock.jdbcex.service;

import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        System.out.println("todoVO: " + todoVO);

        dao.insert(todoVO);
    }

    public TodoDTO get(Long tno) throws Exception {

        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    public void remove(Long tno) throws Exception {
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);
    }
}
