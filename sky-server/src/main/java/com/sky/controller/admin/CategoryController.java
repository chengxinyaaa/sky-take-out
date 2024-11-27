package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sky.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags="分类相关")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类，参数为：{}",categoryDTO);
        categoryService.update(categoryDTO);

        return Result.success();
    }

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询，参数为：{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.page(categoryPageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * 启用禁用分类
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用或禁用分类")
    public Result<T> startOrStop(@PathVariable Integer status, Long id){
        log.info("启用或禁用分类，参数为：{},{}",status,id);
        categoryService.startOrStop(status, id);

        return Result.success();
    }

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<T> save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类，参数为：{}",categoryDTO);
        categoryService.save(categoryDTO);

        return Result.success();
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result<T> deleteById(Long id){
        log.info("删除分类，参数为：{}",id);
        categoryService.deleteById(id);

        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("根据id查询分类，参数为：{}",type);
        List<Category> list = categoryService.list(type);

        return Result.success(list);
    }
}