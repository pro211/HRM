package com.nc.hrm.util;

import com.nc.hrm.model.entity.Salary;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    public static ByteArrayInputStream salariesToExcel(List<Salary> salaries) throws IOException {
        String[] COLUMNs = {"Id", "Tháng", "Mã NV", "Họ Và Tên       ", "Lương Cơ Bản", "Lương Phụ Cấp", "BHXH   ", "BHYT   ",
                "Thuế TNCN", "Khen Thưởng Kỷ Luật", "Thưởng Kinh Doanh", "Thực Lĩnh"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Salaries");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
                sheet.autoSizeColumn(col);

            }

            System.out.println("Size Excel:" + salaries.size());

            int rowIdx = 1;
            for (Salary salary : salaries) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(salary.getId());
                row.createCell(1).setCellValue(salary.getMonth() + "/" + salary.getYear());
                row.createCell(2).setCellValue(salary.getEmployee().getBusinessName());
                row.createCell(3).setCellValue(salary.getEmployee().getEmployeeName());
                row.createCell(4).setCellValue(salary.getContract().getBaseSalary());
                row.createCell(5).setCellValue(salary.getContract().getSubsidiesSalary());
                row.createCell(6).setCellValue(salary.getSocialSecurity());
                row.createCell(7).setCellValue(salary.getHealthInsurance());
                row.createCell(8).setCellValue(salary.getPersonalIncomeTax());
                row.createCell(9).setCellValue(salary.getAchievement());
                row.createCell(10).setCellValue(salary.getCommission());
                row.createCell(11).setCellValue(salary.getTotalIncome());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static ByteArrayInputStream employeeSalaryToExcel(Salary salary) throws IOException {
        String[] COLUMNs = {"Id", "Tháng", "Mã NV", "Họ Và Tên       ", "Lương Cơ Bản", "Lương Phụ Cấp", "BHXH   ", "BHYT   ",
                "Thuế TNCN", "Khen Thưởng Kỷ Luật", "Thưởng Kinh Doanh", "Thực Lĩnh"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Employee Salary");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
                sheet.autoSizeColumn(col);

            }
            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(salary.getId());
            row.createCell(1).setCellValue(salary.getMonth() + "/" + salary.getYear());
            row.createCell(2).setCellValue(salary.getContract().getEmployee().getBusinessName());
            row.createCell(3).setCellValue(salary.getContract().getEmployee().getEmployeeName());
            row.createCell(4).setCellValue(salary.getContract().getBaseSalary());
            row.createCell(5).setCellValue(salary.getContract().getSubsidiesSalary());
            row.createCell(6).setCellValue(salary.getSocialSecurity());
            row.createCell(7).setCellValue(salary.getHealthInsurance());
            row.createCell(8).setCellValue(salary.getPersonalIncomeTax());
            row.createCell(9).setCellValue(salary.getAchievement());
            row.createCell(10).setCellValue(salary.getCommission());
            row.createCell(11).setCellValue(salary.getTotalIncome());
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
