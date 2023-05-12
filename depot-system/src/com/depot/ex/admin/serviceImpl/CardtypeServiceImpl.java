// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.entity.CardType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.CardtypeDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.CardtypeService;

@Service
public class CardtypeServiceImpl implements CardtypeService
{
    @Autowired
    private CardtypeDao cardtypeDao;
    
    public List<CardType> findAllCardType() {
        final List<CardType> cardTypes = this.cardtypeDao.findAllCardType();
        return cardTypes;
    }
    
    public CardType findCardTypeByid(final int typeid) {
        return this.cardtypeDao.findCardTypeByid(typeid);
    }
}
