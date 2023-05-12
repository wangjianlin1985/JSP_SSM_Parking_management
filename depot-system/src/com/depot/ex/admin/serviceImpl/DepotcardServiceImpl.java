// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.depot.ex.admin.entity.Depotcard;
import com.depot.ex.admin.dto.DepotcardManagerData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.DepotcardDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.DepotcardService;

@Service
public class DepotcardServiceImpl implements DepotcardService
{
    @Autowired
    private DepotcardDao depotcardDao;
    
    public List<DepotcardManagerData> findAllDepotcard(final String cardnum, final int page, final int size) {
        final List<DepotcardManagerData> depotcardManagerDatas = this.depotcardDao.findAllDepotcard(cardnum, page, size);
        return depotcardManagerDatas;
    }
    
    public Depotcard save(final DepotcardManagerData depotcardManagerData) {
        final Date date = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final String trans = formatter.format(date);
        final String dateStr = trans.replaceAll(" ", "").replaceAll("-", "");
        final String cardnum = String.valueOf(depotcardManagerData.getUsername()) + dateStr;
        final Depotcard depotcardTem = this.depotcardDao.findByCardnum(cardnum);
        if (depotcardTem != null) {
            return null;
        }
        Depotcard depotcard = new Depotcard();
        depotcard.setCardnum(cardnum);
        depotcard.setMoney(depotcardManagerData.getMoney());
        depotcard.setTime(date);
        depotcard.setType(Integer.parseInt(depotcardManagerData.getType()));
        depotcard.setDeductedtime(depotcardManagerData.getDeductedtime());
        this.depotcardDao.save(depotcard);
        depotcard = this.depotcardDao.findByCardnum(cardnum);
        return depotcard;
    }
    
    public Depotcard findByCardid(final int cardid) {
        return this.depotcardDao.findByCardid(cardid);
    }
    
    public Depotcard findByCardnum(final String cardnum) {
        final Depotcard depotcard = this.depotcardDao.findByCardnum(cardnum);
        return depotcard;
    }
    
    public void updateDepotcardBycardnum(final Depotcard depotcard) {
        this.depotcardDao.updateDepotcardBycardnum(depotcard);
    }
    
    public void deleteDepotCard(final String cardnum) {
        this.depotcardDao.deleteDepotCard(cardnum);
    }
    
    public void addMoney(final String cardnum, final double money) {
        this.depotcardDao.addMoney(cardnum, money);
    }
    
    public int findAllDepotcardCount(final String cardnum) {
        return this.depotcardDao.findAllDepotcardCount(cardnum);
    }
    
    public List<DepotcardManagerData> findByCardId(final int cardid) {
        return this.depotcardDao.findByCardId(cardid);
    }
    
    public void updateCardnum(final String cardnum, final String cardnumNew) {
        this.depotcardDao.updateCardnum(cardnum, cardnumNew);
    }
}
