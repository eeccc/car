package com.example.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.car.entity.Car;
import com.example.car.mapper.CarMapper;
import com.example.car.service.CarService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CarServiceImpl
 * @Desc
 * @Date 2023/11/26 17:55
 * @Version 1.0
 * 你我山巅自相逢
 **/
@Service("carService")
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
}
