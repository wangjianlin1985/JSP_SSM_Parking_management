// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.admin.entity.DepotInfo;
import com.depot.ex.utils.Msg;
import com.depot.ex.admin.dto.ChargeData;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import java.io.IOException;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javax.servlet.http.HttpServletResponse;
import com.depot.ex.admin.dto.EmailData;
import java.util.Iterator;
import com.depot.ex.admin.dto.IncomeData;
import com.depot.ex.admin.dto.CouponData;
import com.depot.ex.admin.dto.DepotcardManagerData;
import com.depot.ex.admin.entity.IllegalInfo;
import com.depot.ex.admin.entity.Depotcard;
import com.depot.ex.admin.dto.ParkinfoallData;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.depot.ex.utils.Constants;
import java.util.ArrayList;
import com.depot.ex.admin.entity.User;
import com.depot.ex.admin.entity.ParkSpace;
import com.depot.ex.utils.PageUtil;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.depot.ex.admin.service.DepotInfoService;
import com.depot.ex.admin.service.EmailService;
import com.depot.ex.admin.service.CouponService;
import com.depot.ex.admin.service.IncomeService;
import com.depot.ex.admin.service.IllegalInfoService;
import com.depot.ex.admin.service.ParkinfoallService;
import com.depot.ex.admin.service.DepotcardService;
import com.depot.ex.admin.service.ParkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController
{
    @Autowired
    private UserService userService;
    @Autowired
    private ParkspaceService parkspaceService;
    @Autowired
    private DepotcardService depotcardService;
    @Autowired
    private ParkinfoallService parkinfoallService;
    @Autowired
    private IllegalInfoService illegalInfoService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private DepotInfoService depotInfoService;
    
    @RequestMapping({ "/index/toindex" })
    public String toIndex(final Model model, final HttpSession session, @RequestParam(value = "tag", required = false) Integer tag, @RequestParam(value = "page", required = false) Integer page) {
        if (tag == null) {
            tag = 0;
        }
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        final PageUtil<ParkSpace> pageUtil = new PageUtil<ParkSpace>();
        pageUtil.setCurrent(page);
        pageUtil.setTag(tag);
        final User user1 = (User)session.getAttribute("user");
        List<ParkSpace> list = new ArrayList<ParkSpace>();
        int count = 0;
        int countPage = 0;
        if (user1 != null) {
            if (user1.getRole() == 1) {
                if (tag == 0) {
                    list = this.parkspaceService.findAllParkspace(page * 10, Constants.PAGESIZE);
                }
                else {
                    list = this.parkspaceService.findParkspaceByTag(tag, page * 10, Constants.PAGESIZE);
                }
                count = this.parkspaceService.findAllParkspaceCount(tag);
            }
            else if (user1.getRole() == 2) {
                if (tag == 0) {
                    list = this.parkspaceService.findAllParkspace(page * 10, Constants.PAGESIZE);
                }
                else {
                    list = this.parkspaceService.findParkspaceByTag(tag, page * 10, Constants.PAGESIZE);
                }
                count = this.parkspaceService.findAllParkspaceCount(tag);
            }
            countPage = count / 10;
            if (count % 10 != 0) {
                ++countPage;
            }
            pageUtil.setCountPage(countPage);
            pageUtil.setCount(count);
            pageUtil.setPages(list);
            model.addAttribute("parkspaces", (Object)pageUtil);
            return "index";
        }
        return "login";
    }
    
    @RequestMapping({ "/index/findAllUser" })
    public String findAllUser(final Model model, final HttpSession session, @RequestParam(value = "tag", required = false) Integer tag, @RequestParam(value = "page", required = false) Integer page) {
        if (tag == null) {
            tag = 0;
        }
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        List<User> users = null;
        User user1 = (User)session.getAttribute("user");
        final PageUtil<User> pageUtil = new PageUtil<User>();
        int count = 0;
        int countPage = 0;
        if (user1 != null) {
            if (user1.getRole() == 1) {
                users = this.userService.findUsersByRole(tag, page * 10, Constants.PAGESIZE);
                count = this.userService.findAllUserCount(tag);
            }
            else if (user1.getRole() == 2) {
                users = this.userService.findUsersByRoleMan(tag, page * 10, Constants.PAGESIZE);
                count = this.userService.findAllUserCountMan(tag);
            }
            else if (user1.getRole() == 3) {
                users = new ArrayList<User>();
                user1 = this.userService.findUserById(user1.getId());
                users.add(user1);
                count = 1;
            }
            else {
                user1.getRole();
            }
        }
        countPage = count / 10;
        if (count % 10 != 0) {
            ++countPage;
        }
        pageUtil.setCountPage(countPage);
        pageUtil.setCount(count);
        pageUtil.setPages(users);
        model.addAttribute("users", (Object)pageUtil);
        return "user";
    }
    
    @RequestMapping({ "/index/findAllDepot" })
    public String findAllDepot(final Model model, final HttpSession session, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        if (name == null) {
            name = "";
        }
        List<ParkinfoallData> parkinfoallDatas = null;
        final PageUtil<ParkinfoallData> pageUtil = new PageUtil<ParkinfoallData>();
        final User user1 = (User)session.getAttribute("user");
        int count = 0;
        int countPage = 0;
        if (user1 != null) {
            if (user1.getRole() == 1) {
                parkinfoallDatas = this.parkinfoallService.findAllParkinfoallByLike(page * 10, Constants.PAGESIZE, name);
                count = this.parkinfoallService.findAllParkinfoallCount(name);
            }
            else if (user1.getRole() == 2) {
                parkinfoallDatas = this.parkinfoallService.findAllParkinfoallByLike(page * 10, Constants.PAGESIZE, name);
                count = this.parkinfoallService.findAllParkinfoallCount(name);
            }
            else if (user1.getRole() == 3) {
                final Depotcard depotcard = this.depotcardService.findByCardid(user1.getCardid());
                parkinfoallDatas = this.parkinfoallService.findByCardNumByPage(page * 10, Constants.PAGESIZE, depotcard.getCardnum(), name);
                final List<ParkinfoallData> parkinfoallDatas2 = this.parkinfoallService.findByCardNum(depotcard.getCardnum(), name);
                count = parkinfoallDatas2.size();
            }
            else {
                user1.getRole();
            }
        }
        countPage = count / 10;
        if (count % 10 != 0) {
            ++countPage;
        }
        pageUtil.setExtra(name);
        pageUtil.setPages(parkinfoallDatas);
        pageUtil.setCount(count);
        pageUtil.setCurrent(page);
        pageUtil.setCountPage(countPage);
        model.addAttribute("parkinfoallDatas", (Object)pageUtil);
        return "depot";
    }
    
    @RequestMapping({ "/index/findAllIllegalinfo" })
    public String findAllIllegalinfo(final Model model, final HttpSession session, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        if (name == null) {
            name = "";
        }
        List<IllegalInfo> illegalInfo = null;
        final PageUtil<IllegalInfo> pageUtil = new PageUtil<IllegalInfo>();
        final User user1 = (User)session.getAttribute("user");
        int count = 0;
        int countPage = 0;
        if (user1 != null) {
            if (user1.getRole() == 1) {
                illegalInfo = this.illegalInfoService.findAllIllegalInfo(page * 10, Constants.PAGESIZE, name);
                count = this.illegalInfoService.findAllIllegalInfoCount(name);
            }
            else if (user1.getRole() == 2) {
                illegalInfo = this.illegalInfoService.findAllIllegalInfo(page * 10, Constants.PAGESIZE, name);
                count = this.illegalInfoService.findAllIllegalInfoCount(name);
            }
            else if (user1.getRole() == 3) {
                illegalInfo = this.illegalInfoService.findByUid(user1.getId());
                count = illegalInfo.size();
            }
            else {
                user1.getRole();
            }
        }
        countPage = count / 10;
        if (count % 10 != 0) {
            ++countPage;
        }
        pageUtil.setExtra(name);
        pageUtil.setPages(illegalInfo);
        pageUtil.setCount(count);
        pageUtil.setCountPage(countPage);
        pageUtil.setCurrent(page);
        model.addAttribute("illegalInfo", (Object)pageUtil);
        return "illegalinfo";
    }
    
    @RequestMapping({ "/index/toDepotcardIndex" })
    public String findAllDepotcard(final Model model, final HttpSession session, @RequestParam(value = "cardnum", required = false) String cardnum, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        List<DepotcardManagerData> depotcardManagerDatas = null;
        final PageUtil<DepotcardManagerData> pageUtil = new PageUtil<DepotcardManagerData>();
        int count = 0;
        int countPage = 0;
        final User user1 = (User)session.getAttribute("user");
        if (cardnum == null) {
            cardnum = "";
        }
        if (user1 != null) {
            if (user1.getRole() == 1) {
                depotcardManagerDatas = this.depotcardService.findAllDepotcard(cardnum, page * 10, Constants.PAGESIZE);
                count = this.depotcardService.findAllDepotcardCount(cardnum);
            }
            else if (user1.getRole() == 2) {
                depotcardManagerDatas = this.depotcardService.findAllDepotcard(cardnum, page * 10, Constants.PAGESIZE);
                count = this.depotcardService.findAllDepotcardCount(cardnum);
            }
            else if (user1.getRole() == 3) {
                depotcardManagerDatas = this.depotcardService.findByCardId(user1.getCardid());
                count = depotcardManagerDatas.size();
            }
            else {
                user1.getRole();
            }
        }
        countPage = count / 10;
        if (count % 10 > 0) {
            ++countPage;
        }
        pageUtil.setExtra(cardnum);
        pageUtil.setCurrent(page);
        pageUtil.setCount(count);
        pageUtil.setCountPage(countPage);
        pageUtil.setPages(depotcardManagerDatas);
        model.addAttribute("depotcardManagerDatas", (Object)pageUtil);
        return "depotcard";
    }
    
    @RequestMapping({ "/index/findAllCoupon" })
    public String findAllCoupon(final Model model, final HttpSession session, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        List<CouponData> list = null;
        final PageUtil<CouponData> pageUtil = new PageUtil<CouponData>();
        int count = 0;
        int countPage = 0;
        final User user1 = (User)session.getAttribute("user");
        if (name == null) {
            name = "";
        }
        if (user1 != null) {
            if (user1.getRole() == 1) {
                list = this.couponService.findAllCoupon(page * 10, Constants.PAGESIZE, name);
                count = this.couponService.findAllDepotcardCount(name);
            }
            else if (user1.getRole() == 2) {
                list = this.couponService.findAllCoupon(page * 10, Constants.PAGESIZE, name);
                count = this.couponService.findAllDepotcardCount(name);
            }
            else if (user1.getRole() == 3) {
                final Depotcard depotcard = this.depotcardService.findByCardid(user1.getCardid());
                list = this.couponService.findAllCouponByCardNum(depotcard.getCardnum(), name);
                count = list.size();
            }
            else {
                user1.getRole();
            }
        }
        countPage = count / 10;
        if (count % 10 > 0) {
            ++countPage;
        }
        pageUtil.setExtra(name);
        pageUtil.setCurrent(page);
        pageUtil.setCount(count);
        pageUtil.setCountPage(countPage);
        pageUtil.setPages(list);
        model.addAttribute("couponDatas", (Object)pageUtil);
        return "coupon";
    }
    
    @RequestMapping({ "/index/findAllIncome" })
    public String findAllIncome(final Model model, final HttpSession session, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "startTime", required = false) String startTime, @RequestParam(value = "endTime", required = false) String endTime, @RequestParam(value = "content", required = false) String content, @RequestParam(value = "num", required = false) Integer num) {
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        if (content == null) {
            content = "";
        }
        if (startTime == null) {
            startTime = "";
        }
        if (endTime == null) {
            endTime = "";
        }
        if (num == null) {
            num = 9;
        }
        List<IncomeData> incomes = null;
        List<IncomeData> incomes2 = null;
        final User user1 = (User)session.getAttribute("user");
        final PageUtil<IncomeData> pageUtil = new PageUtil<IncomeData>();
        int count = 0;
        int countPage = 0;
        double countMoney = 0.0;
        if (user1 != null) {
            if (user1.getRole() == 1) {
                incomes = this.incomeService.findAllIncome(page * 10, Constants.PAGESIZE, content, startTime, endTime, num);
                incomes2 = this.incomeService.findAllIncome(content, startTime, endTime, num);
                if (incomes2.size() > 0) {
                    for (final IncomeData incomeData : incomes2) {
                        countMoney += incomeData.getMoney();
                    }
                }
                count = this.incomeService.findAllIncomeCount(content, startTime, endTime, num);
                countPage = count / 10;
                if (count % 10 != 0) {
                    ++countPage;
                }
                pageUtil.setCurrent(page);
                pageUtil.setCount(count);
                pageUtil.setCountPage(countPage);
                pageUtil.setPages(incomes);
            }
            else if (user1.getRole() != 2 && user1.getRole() != 3) {
                user1.getRole();
            }
        }
        model.addAttribute("incomes", (Object)pageUtil);
        model.addAttribute("countMoney", (Object)countMoney);
        return "income";
    }
    
    @RequestMapping({ "/index/findAllEmail" })
    public String findAllEmail(final Model model, final HttpSession session, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "content", required = false) String content, @RequestParam(value = "tag", required = false) Integer tag) {
        if (page == null) {
            page = 0;
        }
        if (page != 0) {
            --page;
        }
        if (content == null) {
            content = "";
        }
        if (tag == null) {
            tag = 4;
        }
        List<EmailData> emails = null;
        final PageUtil<EmailData> pageUtil = new PageUtil<EmailData>();
        int count = 0;
        int countPage = 0;
        final User user1 = (User)session.getAttribute("user");
        emails = this.emailService.findByUserId(page * 10, Constants.PAGESIZE, user1.getId(), user1.getRole(), content, tag);
        final List<EmailData> emailDatas = new ArrayList<EmailData>();
        for (final EmailData emailData : emails) {
            if (user1.getRole() == 3) {
                emailData.setIsRead(emailData.getUserisread());
            }
            else {
                emailData.setIsRead(emailData.getManagerisread());
            }
            final User sendUser = this.userService.findUserById(emailData.getSendid());
            if (emailData.getToid() != 0) {
                final User toUser = this.userService.findUserById(emailData.getToid());
                emailData.setToUsername(toUser.getUsername());
            }
            else {
                emailData.setToUsername("");
            }
            if (user1.getId() == emailData.getSendid()) {
                emailData.setIsSend(1);
            }
            emailData.setSendUsername(sendUser.getUsername());
            emailDatas.add(emailData);
        }
        count = this.emailService.findAllEmailCountByUser(user1.getId(), user1.getRole());
        countPage = count / 10;
        if (count % 10 != 0) {
            ++countPage;
        }
        pageUtil.setCurrent(page);
        pageUtil.setCount(count);
        pageUtil.setCountPage(countPage);
        pageUtil.setPages(emailDatas);
        model.addAttribute("emails", (Object)pageUtil);
        model.addAttribute("tag", (Object)tag);
        return "email";
    }
    
    @RequestMapping({ "/index/system" })
    public String system(final Model model, final HttpSession session) {
        return "system";
    }
    
    @RequestMapping({ "/index/exit" })
    public String exit(final Model model, final HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
    
    @RequestMapping({ "/index/exportIncome" })
    public void exportIncome(@RequestParam(value = "datetimepickerStart", required = false) String datetimepickerStart, @RequestParam(value = "datetimepickerEnd", required = false) String datetimepickerEnd, final HttpServletResponse response) {
        if (datetimepickerStart == null) {
            datetimepickerStart = "";
        }
        if (datetimepickerEnd == null) {
            datetimepickerEnd = "";
        }
        final List<IncomeData> list = this.incomeService.findAllIncome("", datetimepickerStart, datetimepickerEnd, 9);
        final HSSFWorkbook wb = new HSSFWorkbook();
        final HSSFSheet sheet = wb.createSheet("\u6536\u5165");
        final HSSFRow row1 = sheet.createRow(0);
        final HSSFCell cell = row1.createCell(0);
        cell.setCellValue("\u6536\u5165\u660e\u7ec6");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        final HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("\u8f66\u724c\u53f7");
        row2.createCell(1).setCellValue("\u505c\u8f66\u5361\u53f7");
        row2.createCell(2).setCellValue("\u6536\u5165");
        row2.createCell(3).setCellValue("\u6536\u5165\u65b9\u5f0f");
        row2.createCell(4).setCellValue("\u6536\u5165\u6765\u6e90");
        row2.createCell(5).setCellValue("\u6536\u5165\u65f6\u95f4");
        row2.createCell(6).setCellValue("\u65f6\u957f");
        row2.createCell(7).setCellValue("\u8fdd\u89c4");
        int rowsize = 2;
        for (final IncomeData data : list) {
            final HSSFRow row3 = sheet.createRow(rowsize);
            row3.createCell(0).setCellValue(data.getCarnum());
            row3.createCell(1).setCellValue(data.getCardnum());
            row3.createCell(2).setCellValue(data.getMoney());
            row3.createCell(3).setCellValue((data.getMethod() == 0) ? "\u73b0\u91d1" : ((data.getMethod() == 1) ? "\u652f\u4ed8\u5b9d" : ((data.getMethod() == 2) ? "\u5fae\u4fe1" : "\u6263\u5361\u8d39")));
            row3.createCell(4).setCellValue((data.getSource() == 0) ? "\u5145\u503c" : "\u51fa\u5e93");
            row3.createCell(5).setCellValue(data.getTime());
            row3.createCell(6).setCellValue((double)data.getDuration());
            row3.createCell(7).setCellValue((double)data.getIsillegal());
            ++rowsize;
        }
        try {
            final OutputStream output = (OutputStream)response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=incomeDetail.xls");
            response.setContentType("application/msexcel");
            wb.write(output);
            output.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping({ "/index/setSystem" })
    @ResponseBody
    public Msg setSystem(final ChargeData chargeData) {
        final Integer hourmoney = chargeData.getHourmoney();
        final Integer monthcard = chargeData.getMonthcard();
        final Integer yearcard = chargeData.getYearcard();
        final Integer illegal = chargeData.getIllegal();
        final DepotInfo depotInfo = this.depotInfoService.findById(1);
        if (hourmoney == null || hourmoney == 0) {
            chargeData.setHourmoney(depotInfo.getHourmoney());
        }
        if (monthcard == null || monthcard == 0) {
            chargeData.setMonthcard(depotInfo.getMonthcard());
        }
        if (yearcard == null || yearcard == 0) {
            chargeData.setYearcard(depotInfo.getYearcard());
        }
        if (illegal == null || illegal == 0) {
            chargeData.setIllegal(depotInfo.getIllegal());
        }
        this.depotInfoService.update(chargeData);
        return Msg.success();
    }
}
