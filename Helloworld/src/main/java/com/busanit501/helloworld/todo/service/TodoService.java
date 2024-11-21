package com.busanit501.helloworld.todo.service;

import com.busanit501.helloworld.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//열거형 상수들,
//상수들의 집합, 모음집
public enum TodoService {
    INSTANCE;

    // 글 등록하는 기능.
    public void register(TodoDTO todoDTO) {
        // 디비에 데이터를 쓰는 작업, insert
        System.out.println("글쓰기 작업하는 기능입니다.");
    }
    // 조회, 샘플, 하드코딩, 더미 데이터
    public List<TodoDTO> getList() {
        // 디비에서 데이터를 조회해서, 전달하기.
        // for 문으로 10개의 더미 인스턴스 만들었다.라고 생각하기.
        // 모양만 다름.
        // Stream 객체, 입력 , 출력 한번에 처리하는 기능을 인터페이스, 클래스,
//        List<TodoDTO> todoList2 = new ArrayList<>();
//
//        for (int i=0; i<10; i++) {
//            TodoDTO todoDTO = new TodoDTO();
//            todoDTO.setTitle("테스트BB " + i);
//            todoDTO.setTno((long) i);
//            todoDTO.setDueDate(LocalDate.now());
//            todoList2.add(todoDTO);
//        }

        List<TodoDTO> todoList = IntStream.range(0,10).mapToObj(
                i -> {
                    // 10 반복 해서, 더미 인스턴스 10개 생성,
                    TodoDTO todoDTO = new TodoDTO();
                    todoDTO.setTitle("테스트AA " + i);
                    todoDTO.setTno((long) i);
                    todoDTO.setDueDate(LocalDate.now());
                    return  todoDTO;
                }).collect(Collectors.toList());
        return todoList;
    }

    // 하나 조회, 상세보기 , 게시글에서, 게시글 번호 클릭시 나타나는 데이터
    public TodoDTO getOne(Long tno) {
        // 실제로, 디비에서 데이터 받아 와야 하지만,
        // 더미 데이터 이용하기.
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setTno(5L);
        todoDTO.setTitle("하나 조회 더미 데이터");
        todoDTO.setDueDate(LocalDate.now());
        return todoDTO;
    }

}


// 예시, TodoService.INSTANCe
// private final String str = "test";
