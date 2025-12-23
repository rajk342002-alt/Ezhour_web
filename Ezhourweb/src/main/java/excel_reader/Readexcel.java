package excel_reader;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {
	static XSSFWorkbook workbook;
	public String[][] getexceldata(String sheetname)  {
		
		
		String filelocation="./excel-data/ezhour-data.xlsx";
		
		try {
			workbook = new XSSFWorkbook(filelocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
XSSFSheet sheet=workbook.getSheet(sheetname);
int lastrow=sheet.getLastRowNum();
Short lastcell=sheet.getRow(0).getLastCellNum();

String[][] data=new String[lastrow][lastcell];
for(int r=1;r<=lastrow;r++) {
XSSFRow row= sheet.getRow(r);

for(int c=0;c<lastcell;c++)
{
XSSFCell cell =row.getCell(c);

//String value=cell.getStringCellValue();

DataFormatter dtr=new DataFormatter();
String datas=dtr.formatCellValue(cell);
//System.out.println(datas);
data[r-1][c]=datas;
	}
	}
return data;
	}
	
}
