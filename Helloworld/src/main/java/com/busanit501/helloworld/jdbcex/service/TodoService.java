package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import com.busanit501.helloworld.todo.dto.TodoDTO;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;

public enum TodoService {
    INSTANCE;
    // 2가지, 다른 클래스에 의존함.
    // 1) 모델 맵퍼 기능
    // 2) DAO 기능

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    // 생성자 이용해서, 초기화하기.
    TodoService(){
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //crud , 기본 테스트,
    // 직접 적인 디비 비지니스 로직, DAO 다 있어서,
    // 여기서는 기능 명세서 , 기능 모음짐,
    // DAO 에 의존해서 이용하기.

    //1
    // register
    // 화면에서 등록된 내용이 -> DTO 박스에 담아서-> 서비스 계층에 전달.
    public void register (TodoDTO todoDTO) throws SQLException {
        // DAO 작업할 때, 디비에 직접적인 영향을 주는 객체,
        // VO, 실제 비지니스 로직에서만 사용함.
        // 서블릿 > DTO 전달 받고, -> DAO 한테 전달할 때, 다시, VO 변환해야함.
        // 변환 하는 도구,
        // 도구를 사용안하면,
//        TodoVO todoVO = new TodoVO();
//        todoVO.setTno(todoDTO.getTno());
//        todoVO.setTitle(todoDTO.getTitle());
//        todoVO.setDueDate(todoDTO.getDueDate());
//        todoVO.setFinished(todoDTO.isFinished());

        // 모델 맵퍼 이용시.
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
        System.out.println("todoVo : "+ todoVO);

        // DAO 외주 맡기기,
        todoDAO.insert(todoVO);
    }

}
