package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class tc_009Page {
    private static final String EXCEL_FILE_PATH = "path_to_report_file.xlsx";

    public void openExcelFile() {
        // Logic to open and validate Excel file can be implemented here
        // For test purposes, actual file operations would be mocked or handled differently
    }

    public boolean isFolioDePagoColumnCorrect() {
        try (FileInputStream file = new FileInputStream(new File(EXCEL_FILE_PATH))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            int folioPreSolicitudIndex = findCellIndex(headerRow, "Folio Pre solicitud");
            int folioDePagoIndex = findCellIndex(headerRow, "Folio de Pago");

            if (folioPreSolicitudIndex != -1 && folioDePagoIndex == folioPreSolicitudIndex + 1) {
                Row firstDataRow = sheet.getRow(1);
                if (firstDataRow != null && firstDataRow.getCell(folioDePagoIndex).getStringCellValue().isEmpty()) {
                    workbook.close();
                    return true;
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int findCellIndex(Row row, String cellContent) {
        for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
            if (row.getCell(cellNum) != null && row.getCell(cellNum).getStringCellValue().equalsIgnoreCase(cellContent)) {
                return cellNum;
            }
        }
        return -1;
    }
}