package org.inh3rit.financial.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 13:57 2019-09-17
 */
@Repository
public interface DemoDao {

    void delById(@Param("id") String id);
}
