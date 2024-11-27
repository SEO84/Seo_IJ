package com.busanit501.helloworld.food.controller;



import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FoodListController",urlPatterns = "/food/list")
public class FoodListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet : FoodListController 한글 테스트");
        List<FoodDTO> foodList = null;
        try {
            foodList = FoodService.INSTANCE.listAll();
            request.setAttribute("list", foodList);
            request.getRequestDispatcher("/WEB-INF/food/foodList.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
