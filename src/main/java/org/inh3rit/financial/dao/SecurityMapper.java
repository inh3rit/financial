package org.inh3rit.financial.dao;

import org.apache.ibatis.annotations.Param;
import org.inh3rit.financial.model.Security;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SecurityMapper {
    int deleteByPrimaryKey(String securityCode);

    int insert(Security record);

    int insertSelective(Security record);

    void batchInsert(@Param("securities") List<Security> securities);

    Security selectByPrimaryKey(String securityCode);

    int updateByPrimaryKeySelective(Security record);

    int updateByPrimaryKey(Security record);

    Set<String> selectAllSecurityCode();
}