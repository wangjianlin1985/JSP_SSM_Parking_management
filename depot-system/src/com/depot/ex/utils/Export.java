// 
// 
// 

package com.depot.ex.utils;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javax.servlet.http.HttpServletResponse;

public class Export
{
    public String createExcel(final HttpServletResponse response) throws IOException {
        final HSSFWorkbook wb = new HSSFWorkbook();
        final HSSFSheet sheet = wb.createSheet("\u6210\u7ee9\u8868");
        final HSSFRow row1 = sheet.createRow(0);
        final HSSFCell cell = row1.createCell(0);
        cell.setCellValue("\u5b66\u5458\u8003\u8bd5\u6210\u7ee9\u4e00\u89c8\u8868");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        final HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("\u59d3\u540d");
        row2.createCell(1).setCellValue("\u73ed\u7ea7");
        row2.createCell(2).setCellValue("\u7b14\u8bd5\u6210\u7ee9");
        row2.createCell(3).setCellValue("\u673a\u8bd5\u6210\u7ee9");
        final HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("\u674e\u660e");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87.0);
        row3.createCell(3).setCellValue(78.0);
        final OutputStream output = (OutputStream)response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }
}
