package com.example.car.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.car.entity.Car;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName CarMapper
 * @Desc
 * @Author wangjian
 * @Date 2023/11/26 17:50
 * @Version 1.0
 * 你我山巅自相逢
 **/
@Mapper
public interface CarMapper extends BaseMapper<Car> {
}
