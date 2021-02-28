package com.element.hydrogen.mapper.user;

import com.element.hydrogen.entity.user.AccountCodeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountCodeMapper {
    int deleteByPrimaryKey(String donAccountCodeId);

    int insert(AccountCodeEntity record);

    int insertSelective(AccountCodeEntity record);

    AccountCodeEntity selectByPrimaryKey(String donAccountCodeId);

    int updateByPrimaryKeySelective(AccountCodeEntity record);

    int updateByPrimaryKey(AccountCodeEntity record);

    /**
     * 登录-查询
     * @param accountCodeEntity
     * @return
     */
    AccountCodeEntity query(AccountCodeEntity accountCodeEntity);
}