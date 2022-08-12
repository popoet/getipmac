package com.zxk.controller;

import com.zxk.entity.UserBean;
import com.zxk.mapper.InfoMapper;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xueke
 * @create 2022-08-04 16:54
 */
@Controller
public class UserController {
    @Resource
    InfoMapper infoMapper;

    /**
     * 展示列表
     * @param model
     * @return
     */
    @RequestMapping("/listInfo")
    public String listInfo(Model model){
        List<UserBean> list = infoMapper.findAll();
        model.addAttribute("list",list);
        return "listInfo";
    }


    /**
     * 导出excel
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
    public void downloadAllInfo(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();//创建HSSFWorkbook对象,  excel的文档对象
        HSSFSheet sheet = workbook.createSheet("信息表"); //excel的表单

        List<UserBean> allinfo = infoMapper.findAll();

        String fileName = "ip&macInfor"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "姓名", "部门", "ip地址", "mac地址"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (UserBean userBean : allinfo) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(userBean.getBi_name());
            row1.createCell(1).setCellValue(userBean.getBi_department());
            row1.createCell(2).setCellValue(userBean.getBi_ip());
            row1.createCell(3).setCellValue(userBean.getBi_mac());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }

}


