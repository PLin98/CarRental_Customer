package com.rin.bus.mapper;

import java.util.List;


import com.rin.bus.domain.Rent;

public interface RentMapper {
    int deleteByPrimaryKey(String rentid);

    int insert(Rent record);
    int updateByPrimaryKeySelective(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(String rentid);

    

    int updateByPrimaryKey(Rent record);
    
    //查询
    public List<Rent> queryAllRent(Rent rent);

    List<Rent> queryRent(String identity);

    
}