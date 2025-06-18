package site.currychoco.assetmanager.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetExcelOutputDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
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

    public static List<Asset> parseAssetExcelInput(MultipartFile file) {
        List<Asset> result = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new HSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // 헤더 스킵
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Asset asset = new Asset(
                        getCellValue(row.getCell(0)),
                        getCellValue(row.getCell(1)),
                        getCellValue(row.getCell(2)),
                        getCellValue(row.getCell(3)));

                result.add(asset);
            }

        } catch (Exception e) {
            e.printStackTrace(); // 실제 서비스에서는 로그 처리 권장
        }

        return result;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue()); // 정수로 가정
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

}
