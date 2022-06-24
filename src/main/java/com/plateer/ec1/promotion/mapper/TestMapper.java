package com.plateer.ec1.promotion.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface TestMapper {

    @Transactional
    Integer testMapper();
}
