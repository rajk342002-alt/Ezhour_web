package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Dynamically determine number of cells in the row
                int numColumns = row.getLastCellNum(); // returns short
                Object[] rowData = new Object[numColumns];

                for (int i = 0; i < numColumns; i++) {
                    Cell cell = row.getCell(i);
                    rowData[i] = (cell != null) ? cell.toString().trim() : "";
                }

                data.add(rowData);
            }

            workbook.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Convert list to Object[][]
        Object[][] result = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }
}

