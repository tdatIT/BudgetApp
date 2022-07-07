package com.datit.excel;

import com.datit.model.Budget;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFileExcel {

    public static void WriteFile(String namefile, List<Budget> list) {
        int rowcount = 0;
        try {
            FileOutputStream fileOut = new FileOutputStream(namefile);
            //create new work book
            Workbook workbook = new XSSFWorkbook();
            //create new sheet
            Sheet sheet = workbook.createSheet("Sheet1");
            //create header row,set data and set style
            Row rowheader = sheet.createRow(rowcount);
            rowheader.createCell(0).setCellValue("Id");
            rowheader.createCell(1).setCellValue("Title");
            rowheader.createCell(2).setCellValue("Create day");
            rowheader.createCell(3).setCellValue("Values");
            rowheader.createCell(4).setCellValue("Status");
            //create row data
            for (Budget bg : list) {
                rowcount++;
                Row rows = sheet.createRow(rowcount);
                rows.createCell(0).setCellValue(bg.getId());
                rows.createCell(1).setCellValue(bg.getTitle());
                rows.createCell(2).setCellValue(bg.getCreateDate().toString());
                rows.createCell(3).setCellValue(bg.getValues());
                rows.createCell(4).setCellValue(bg.getStatus()?"INCOME":"PAY");
            }
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            JOptionPane.showMessageDialog(null, "Write file success", "Notification",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Write file fail", "Notification",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
