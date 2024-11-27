package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


//열거형 상수들,
//상수들의 집합, 모음집
@Log4j2
public enum FoodService {
    INSTANCE;

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //1
    // register
    public void register(FoodDTO foodDTO) throws SQLException {
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        log.info("foodVO : " + foodVO);
        foodDAO.insert(foodVO);
    } // register

    //2
    // 전체 조회
    public List<FoodDTO> listAll() throws SQLException {
        List<FoodVO> voList = foodDAO.selectAll();
        log.info("voList : " + voList);
        List<FoodDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, FoodDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    //3
    // 하나 조회, 상세보기.
    public FoodDTO get(Long fno) throws SQLException {
        log.info("fno : " + fno);
        ///  디비에서 하나 조회 결과 받았음.
        FoodVO foodVO = foodDAO.selectOne(fno);
        // VO -> DTO 변환 작업.
        FoodDTO foodDTO = modelMapper.map(foodVO,FoodDTO.class);
        return foodDTO;

    }
    //4 수정 기능
    public void update(FoodDTO foodDTO) throws SQLException {

        log.info("foodDTO : " + foodDTO);
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodDAO.updateOne(foodVO);

    }



}

