package com.czy.seed.mvc.wbm.test.mapper;

import com.czy.seed.mvc.wbm.test.entity.TestEntity;
import com.czy.seed.mybatis.base.mapper.BaseMapper;
import com.czy.seed.mybatis.config.mybatis.annotations.AutoMapper;

/**
 * Created by panlc on 2017-03-17.
 */
@AutoMapper
public interface SqlServerMapper extends BaseMapper<TestEntity> {

}
