package com.kaider.cloud.dao;

import com.kaider.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author kaider
 * @Date 2020-05-04 16:16
 * @Version 1.0
 * @Description TODO
 **/
@Mapper
public interface PaymentDao {

    @Insert("insert into payment(serial) values (#{serial});")
    int create(Payment payment);

    @Select("select * from payment where id = #{id};")
    Payment getPaymentById(@Param("id") Long id);


}
