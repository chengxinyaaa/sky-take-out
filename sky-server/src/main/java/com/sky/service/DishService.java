package com.sky.service;

import com.sky.dto.DishDTO;
import org.springframework.context.annotation.Bean;

public interface DishService {
    /**
     * 新增菜品和对应口味数据
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
}
