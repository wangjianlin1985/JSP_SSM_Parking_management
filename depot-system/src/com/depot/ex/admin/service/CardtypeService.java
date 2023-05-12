// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.CardType;
import java.util.List;

public interface CardtypeService
{
    List<CardType> findAllCardType();
    
    CardType findCardTypeByid(int p0);
}
