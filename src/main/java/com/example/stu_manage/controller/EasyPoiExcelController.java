package com.example.stu_manage.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.stu_manage.entity.StudentEntity;
import com.example.stu_manage.entity.TeacherEntity;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.ExcelStuService;
import com.example.stu_manage.service.ExcelTeaService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.R;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.controller
 * 类名：EasyPoiExcelController
 * 功能：使用easypoi注解进行导入导出
 * 备注：
 * 创建人：typ
 * 创建时间：2019/5/19 20:00
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
@RequestMapping("/easypoi")
public class EasyPoiExcelController {

    private static final Logger log = LoggerFactory.getLogger(EasyPoiExcelController.class);

    @Autowired
    private ExcelStuService excelStuService;
    @Autowired
    private ExcelTeaService excelTeaService;


    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response){
        log.info("请求 exportExcel start ......");

        // 获取用户信息
        List<StudentEntity> list = excelStuService.selectList(new EntityWrapper<StudentEntity>());

        try {
            // 设置响应输出的头类型及下载文件的默认名称
            String fileName = new String("demo信息表.xls".getBytes("utf-8"), "ISO-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-excel;charset=gb2312");

            //导出
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), UserEntity.class, list);
            workbook.write(response.getOutputStream());
            log.info("请求 exportExcel end ......");
        } catch (IOException e) {
            log.info("请求 exportExcel 异常：{}", e.getMessage());
        }
    }
    public File upload(MultipartFile file){
        if (file.isEmpty())
            return null;
        String fileName = file.getOriginalFilename();
        if (!(fileName.endsWith(".xls")||fileName.endsWith(".xlsx")))
            return null;
        String filePath = "E:\\upload\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            log.info("");
            return dest;
        } catch (IOException e) {
            log.error(e.toString(), e);
            return null;
        }
    }
    @PostMapping("/stuimportExcel")
    public R stuimportExcel(@RequestParam("file") MultipartFile file,@RequestParam("params")String class_id) {
        //System.out.println(23333);
        File dest = upload(file);
        if (dest == null)
            return R.error("上传失败");
        try{
            List<StudentEntity> list_stuinfo = ExcelImportUtil.importExcel(
                    dest,
                    StudentEntity.class,
                    new ImportParams()
            );
            // 数据打印
            System.out.println(JSON.toJSON(list_stuinfo));
            //完成数据库相关表维护
            excelStuService.doinsert(list_stuinfo,class_id);
            return R.ok("上传数据库成功");
        } catch (Exception e){
            log.info(" Excel 导入异常：{}", e.getMessage());
            return R.error("上传数据库失败！");
        }
    }
    @PostMapping("/teaimportExcel")
    public R teaimportExcel(@RequestParam("file") MultipartFile file) {
        File dest = upload(file);
        if (dest == null)
            return R.error("上传失败");
        try{
            List<TeacherEntity> list_teainfo = ExcelImportUtil.importExcel(
                    dest,
                    TeacherEntity.class,
                    new ImportParams()
            );
            // 数据打印
            System.out.println(JSON.toJSON(list_teainfo));
            excelTeaService.doinsert(list_teainfo);
            return R.ok("上传数据库成功");
        } catch (Exception e){
            log.info(" Excel 导入异常：{}", e.getMessage());
            return R.error("上传数据库失败！");
        }
    }
}