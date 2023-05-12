// 
// 
// 

package com.depot.ex.admin.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.depot.ex.admin.entity.CardType;

public interface CardtypeDao extends BaseDao<CardType>
{
    List<CardType> findAllCardType();
    
    CardType findCardTypeByid(@Param("typeid") int p0);
}
