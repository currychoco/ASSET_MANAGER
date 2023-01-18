package site.currychoco.assetmanager.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import site.currychoco.assetmanager.asset.domain.AssetCategoryNameDto;
import site.currychoco.assetmanager.asset.domain.AssetExcelOutputDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    public static ByteArrayInputStream createListToExcel(List<String> excelHeader, List<AssetExcelOutputDto> excelAssetList) {
        try(Workbook workbook = new HSSFWorkbook()){
            Sheet sheet = workbook.createSheet("assetList");
            Row row;
            Cell cell;
            int rowNo = 0;

            int headerSize = excelHeader.size();

            CellStyle headStyle = workbook.createCellStyle();

            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);

            headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            headStyle.setAlignment(HorizontalAlignment.CENTER);

            row = sheet.createRow(rowNo++);
            for(int i = 0; i<headerSize; i++){
                cell = row.createCell(i);
                cell.setCellStyle(headStyle);
                cell.setCellValue(excelHeader.get(i));
            }

            for(int j = 0; j<excelAssetList.size(); j++){
                Row dataRow = sheet.createRow(j + 1);
                dataRow.createCell(0).setCellValue(excelAssetList.get(j).getId());
                dataRow.createCell(1).setCellValue(excelAssetList.get(j).getSerialnumber());
                dataRow.createCell(2).setCellValue(excelAssetList.get(j).getAssetState());
                dataRow.createCell(3).setCellValue(excelAssetList.get(j).getRegDate().toString());
                dataRow.createCell(4).setCellValue(excelAssetList.get(j).getModel());
                dataRow.createCell(5).setCellValue(excelAssetList.get(j).getCategoryName());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
