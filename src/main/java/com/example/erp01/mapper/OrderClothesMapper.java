package com.example.erp01.mapper;

import com.example.erp01.model.OrderClothes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
//@Repository
public interface OrderClothesMapper {

    int addOrderClothes(List<OrderClothes> orderClothesList);

    List<OrderClothes> getAllOrderClothes();

    String getOrderSummary();

    List<OrderClothes> getByNameDate(String orderName, Date orderDate);

    int deleteByNameDate(String orderName, Date orderDate);

    //订单输入下拉提示
    List<String> getOrderHint(String subOrderName);

    //颜色下拉提示
    List<String> getColorHint(String orderName);

    //输入订单自动带出顾客名
    String getCustomerNameByOrderName(String orderName);


}
