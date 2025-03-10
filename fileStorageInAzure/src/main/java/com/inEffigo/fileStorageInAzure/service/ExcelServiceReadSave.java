package com.inEffigo.fileStorageInAzure.service;

import com.inEffigo.fileStorageInAzure.entity.Employee;
import com.inEffigo.fileStorageInAzure.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ExcelServiceReadSave {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void readExcelAndSaveData(MultipartFile file) throws IOException{
        try(Workbook workbook = new XSSFWorkbook(file.getInputStream())){

            Sheet sheet = workbook.getSheetAt(0);

            log.info("Sheet name: " + sheet);

            for(Row row : sheet){
                if (row.getRowNum() == 0) continue;

                Employee employee = new Employee();

                employee.setName(row.getCell(0).getStringCellValue());
                employee.setEmail(row.getCell(1).getStringCellValue());
                employee.setDepartment(row.getCell(2).getStringCellValue());

                employeeRepository.save(employee);
            }
        }
    }
}
