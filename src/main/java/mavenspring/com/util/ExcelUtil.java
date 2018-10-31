package mavenspring.com.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {
	public static HSSFWorkbook  getHssfWorkbook(String sheetName,String title[],String [][]value,HSSFWorkbook wb){
		//创建一个HSSFWorkbook  对应一个excel文件
		if(wb ==null){
			wb = new HSSFWorkbook();
		}
		//第二部 添加sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		//第三部 在sheet中添加表头第0行
		HSSFRow  row = sheet.createRow(0);
		
		//第四部 创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle  style= wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//声明列对象
		HSSFCell cell = null;
		//创建标题
		for(int i = 0;i<title.length;i++){
			cell = row.createCell(i);
			
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
			
		}
		//创建内容
		for(int j = 0;j<value.length;j++){
			row = sheet.createRow(j+1);
			for(int k=0;k<value[j].length;k++){
				cell = row.createCell(k);
				cell.setCellValue(value[j][k]);
			}
		}
		return wb;
		
	}

}
