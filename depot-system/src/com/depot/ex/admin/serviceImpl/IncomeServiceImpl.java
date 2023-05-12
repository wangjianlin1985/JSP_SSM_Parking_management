// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.dto.IncomeData;
import java.util.List;
import com.depot.ex.admin.entity.Income;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.IncomeDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService
{
    @Autowired
    private IncomeDao incomeDao;
    
    public void save(final Income income) {
        this.incomeDao.save(income);
    }
    
    public List<IncomeData> findAllIncome(final int page, final int size, final String content, final String startTime, final String endTime, final int num) {
        return this.incomeDao.findAllIncome(page, size, content, startTime, endTime, num);
    }
    
    public Income findById(final Integer id) {
        return this.incomeDao.findById(id);
    }
    
    public int findAllIncomeCount(final String content, final String startTime, final String endTime, final int num) {
        return this.incomeDao.findAllIncomeCount(content, startTime, endTime, num);
    }
    
    public void updateCardnum(final String cardnum, final String cardnumNew) {
        this.incomeDao.updateCardnum(cardnum, cardnumNew);
    }
    
    public List<IncomeData> findAllIncome(final String content, final String startTime, final String endTime, final Integer num) {
        return this.incomeDao.findAllIncome1(content, startTime, endTime, num);
    }
}
