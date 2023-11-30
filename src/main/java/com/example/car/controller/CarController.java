package com.example.car.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.car.entity.Car;
import com.example.car.entity.Result;
import com.example.car.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName CarController
 * @Desc
 * @Date 2023/11/26 17:58
 * @Version 1.0
 * 你我山巅自相逢
 **/
@RestController
@RequestMapping("/home")
@CrossOrigin
public class CarController {

    @Resource
    private CarService carService;

    /**
     * 分页
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public Result page(Integer page,Integer pageSize,String name){
        LambdaQueryWrapper<Car> queryWrapper = Wrappers.lambdaQuery(Car.class);
        queryWrapper.like(StringUtils.isNotBlank(name),Car::getName,name);
        if (Objects.isNull(page)){
            page = 0;
        }else{
            page = page-1;
        }
        Page p = new Page();
        p.setCurrent(page);
        p.setSize(pageSize);
        return Result.buildSuccess(carService.page(p,queryWrapper));
    }

    /**
     * 借出
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result lend(@PathVariable("id")Long id){
        LambdaUpdateWrapper<Car> updateWrapper = Wrappers.lambdaUpdate(Car.class);
        updateWrapper.set(Car::getStatus,0).eq(Car::getId,id);
        return Result.buildSuccess(carService.update(updateWrapper));
    }

    /**
     * 归还
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result giveBack(@PathVariable("id")Long id){
        LambdaUpdateWrapper<Car> updateWrapper = Wrappers.lambdaUpdate(Car.class);
        updateWrapper.set(Car::getStatus,1).eq(Car::getId,id);
        return Result.buildSuccess(carService.update(updateWrapper));
    }

    /**
     * 新增
     * @param car
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Car car){
        return Result.buildSuccess(carService.save(car));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping
    public Result del(Long id){
        return Result.buildSuccess(carService.removeById(id));
    }
}
