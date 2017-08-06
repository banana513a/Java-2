package com.blackybear.common;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: Execl Utility
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class ExeclUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 字符
    private static DecimalFormat df = new DecimalFormat("0");// 格式化 number String
    private static DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字

    /**
     * 获取excel 文件
     * @param file
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(File file) throws Exception {
        String fileName = file.getName();
        String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName
                .substring(fileName.lastIndexOf(".") + 1);
        FileInputStream fis = new FileInputStream(file);
        // 根据不同的文件名返回不同类型的WorkBook
        if (extension.equals("xls")) {
            return new HSSFWorkbook(fis);
        } else if (extension.equals("xlsx")) {
            return new XSSFWorkbook(fis);
        } else {
            throw new Exception("不支持该格式的文件！");
        }
    }
    /**
     * 读取excel 文件
     * @param file
     * @param startSheet
     * @param startRow
     * @return
     */
    public static List<List<Object>> readExcel(File file, int startSheet, int startRow) {
        List<List<Object>> list = new LinkedList<List<Object>>();
        Workbook wb = null;
        try {
            wb = getWorkbook(file);
            Sheet sheet = wb.getSheetAt(startSheet);
            Object value = null;
            Row row = null;
            Cell cell = null;
            CellStyle cs = null;
            String csStr = null;
            Double numval = null;
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                row = (Row) rows.next();
                if(row.getRowNum() >= startRow){
                    List<Object> cellList = new LinkedList<Object>();;
                    Iterator<Cell> cells = row.cellIterator();
                    while (cells.hasNext()) {
                        cell = (Cell) cells.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                cs = cell.getCellStyle();
                                csStr = cs.getDataFormatString();
                                numval = cell.getNumericCellValue();
                                if ("@".equals(csStr)) {
                                    value = df.format(numval);
                                } else if ("General".equals(csStr)) {
                                    value = nf.format(numval);
                                } else {
                                    value = sdf.format(HSSFDateUtil.getJavaDate(numval));
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                if (!cell.getStringCellValue().equals("")) {
                                    value = cell.getStringCellValue();
                                } else {
                                    value = cell.getNumericCellValue() + "";
                                }
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                value = "";
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                value = cell.getBooleanCellValue();
                                break;
                            default:
                                value = cell.toString();
                        }
                        cellList.add(value);
                    }
                    list.add(cellList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 反射实体字段生成Excel
     * @param title 标题
     * @param headers 表头
     * @param dataSet 数据集
     * @param outputStream 输出流
     * @return
     */
    @SuppressWarnings({ "deprecation", "unchecked" })
    public static <T> boolean createExcel(String title, String[] headers, Collection<T> dataSet, OutputStream outputStream) {
        boolean result = true;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(title);
        sheet.setDefaultColumnWidth((short) 25);         // 设置表格默认列宽度为15个字节
        // 标题样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(HSSFColor.BLUE.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.WHITE.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleStyle.setFont(font);
        // 内容样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(font2);

        // 生成表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(titleStyle);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 生成数据行
        Iterator<T> iterator = dataSet.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) iterator.next();
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(cellStyle);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Class<?> clazz = t.getClass();
                    Method getMethod = clazz.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    cell.setCellValue(value ==  null ? "" : value.toString());
                } catch (SecurityException e) {
                    e.printStackTrace();
                    result = false;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    result = false;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    result = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    result = false;
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    result = false;
                } finally {

                }
            }
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
