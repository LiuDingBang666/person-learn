package icu.liuwisdom.excel;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HtmlUtil;
import icu.liuwisdom.utils.DateUtils;
import icu.liuwisdom.utils.FileUtils;
import icu.liuwisdom.utils.UidUtils;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Excel Utils
 *
 * @author LDB
 * @version 1.0
 * @date 2023-02-15 22:53
 */

public class ExcelUtils {

    public static final String XLS = ".xls";

    public static final String XLSX = ".xlsx";

    /**
     * 默认文件后缀
     *
     * @author LDB
     * @date 2023-02-19 10:59
     * @version 1.0
     */
    public static final String DEFAULT_FILE_SUFFIX = XLSX;
    /**
     * 默认字段开始行
     *
     * @author LDB
     * @date 2023-02-19 11:04
     * @version 1.0
     */
    public static final Integer DEFAULT_FIELD_ROW = 1;
    public static final Integer DEFAULT_SHEET_ROW = 0;
    /**
     * 默认数据开始行
     *
     * @author LDB
     * @date 2023-02-19 11:04
     * @version 1.0
     */

    public static final Integer DEFAULT_DATA_START_ROW = 2;

    public static final String DEFAULT_SHEET_NAME = "工作表1";

    /**
     * 创建工作表
     *
     * @return org.apache.poi.ss.usermodel.Workbook
     * @author LDB
     * @date 2023-02-17
     **/
    public static Workbook createWorkBook(String type) {
        try {
            Workbook workbook = null;
            if (isXls(type)) {
                // xls
                workbook = new HSSFWorkbook();
            } else if (isXlsx(type)) {
                // xlsx
                workbook = new XSSFWorkbook();
            }
            return workbook;
        } catch (Exception e) {
            throw new RuntimeException("创建工作表失败");
        }
    }

    /**
     * 创建表
     *
     * @param workbook
     * @param name
     * @return org.apache.poi.ss.usermodel.Sheet
     * @author LDB
     * @date 2023-02-17
     **/
    public static Sheet createSheet(Workbook workbook, String name) {
        return workbook.createSheet(WorkbookUtil.createSafeSheetName(name));
    }

    public static Sheet createSheet(Workbook workbook) {
        return createSheet(workbook, DEFAULT_SHEET_NAME);
    }


    /**
     * 将工作薄写入到文件中
     *
     * @param workbook
     * @param file
     * @return java.io.File
     * @author LDB
     * @date 2023-02-17
     **/
    public static File WriteFile(Workbook workbook, File file) {
        try {
            final FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
        } catch (Exception e) {
            throw new RuntimeException("将工作表文件写入文件失败");
        }
        return file;
    }


    /**
     * 文件传送
     *
     * @param file
     * @return java.io.File
     * @author LDB
     * @date 2023-02-17
     **/
    public static File MultipartFileToFile(MultipartFile file) {
        File newFile = null;
        try {
            newFile = FileUtils.createTempFileByPath(file.getOriginalFilename());
            file.transferTo(newFile);
        } catch (Exception e) {
            throw new RuntimeException("将外部文件转临时文件失败!");
        }
        return newFile;
    }

    /**
     * 通过外部文件获取工作薄
     *
     * @param file
     * @return org.apache.poi.ss.usermodel.Workbook
     * @author LDB
     * @date 2023-02-17
     **/
    public static Workbook getWorkbookByMultipartFile(MultipartFile file) {
        return getWorkbookByFile(MultipartFileToFile(file));
    }

    /**
     * 通过文件获取工作薄
     *
     * @param file
     * @return org.apache.poi.ss.usermodel.Workbook
     * @author LDB
     * @date 2023-02-17
     **/
    public static Workbook getWorkbookByFile(File file) {
        try {
            return WorkbookFactory.create(file);
        } catch (Exception e) {
            throw new RuntimeException("通过文件获取工作薄失败");
        }
    }

    /**
     * 通过文件读取数据
     *
     * @param file
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author LDB
     * @date 2023-02-18
     **/
    public static List<Map<String, Object>> readExcelByMultipartFile(MultipartFile file) {
        return readExcelByFile(MultipartFileToFile(file));
    }


    /**
     * 获取导入数据
     *
     * @param file
     * @param classz
     * @return java.util.List<T>
     * @author LDB
     * @date 2023-02-18
     **/
    public static <T> List<T> getImportData(MultipartFile file, Class<T> classz) {
        final List<Map<String, Object>> maps = readExcelByMultipartFile(file);
        return maps.stream().map(val -> BeanUtil.mapToBean(val, classz, true)).collect(Collectors.toList());
    }

    /**
     * 获取导出后的文件
     *
     * @param data     需要导出的数据
     * @param tempName 模板名称
     * @return java.lang.String
     * @author LDB
     * @date 2023-02-18
     **/
    public static <T> String getExportFile(List<T> data, String tempName) {
        // 1、获取工作薄
        val workbook = ExcelUtils.getWorkbookByFile(new File(FileUtils.getTemplatePath() + tempName));
        final Sheet sheet = workbook.getSheetAt(DEFAULT_SHEET_ROW);
        // 读取模板字段
        final Map<Integer, String> fields = readFieldsBySheet(sheet, DEFAULT_FIELD_ROW);
        final CellStyle defaultCellStyle = ExcelUtils.defaultCellStyle(workbook);
        // 3、创建行和列
        Integer idx = 0;
        for (int i = DEFAULT_DATA_START_ROW; i < data.size() + DEFAULT_DATA_START_ROW; i++) {
            final Row row = sheet.createRow(i);
            final T item = data.get(idx++);
            final Map<String, Object> beanMap = BeanUtil.beanToMap(item);
            // 提供三种不同的格式工具
            SimpleDateFormat AllFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);
            SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtils.YYYY_MM_DD);
            SimpleDateFormat timeFormat = new SimpleDateFormat(DateUtils.HH_MM_SS);
            for (int j = 0; j < fields.size(); j++) {
                final Cell cell = row.createCell(j);
                cell.setCellStyle(defaultCellStyle);
                final Object o = beanMap.get(fields.get(j));
                if (Objects.isNull(o)) {
                    cell.setCellValue("");
                } else if (o instanceof Boolean) {
                    // Boolean值
                    cell.setCellValue((Boolean) o);
                } else if (isDate(o)) {
                    // 时间
                    if (o instanceof Date) {
                        Date date = (Date) o;
                        if (date.getYear() > 0 && date.getHours() == 0 && date.getMinutes() == 0 && date.getSeconds() == 0) {
                            // YYYY-MM-DD
                            cell.setCellValue(dateFormat.format(date));
                        } else if (date.getYear() == 70 && date.getMonth() == 0 && date.getDay() == 4) {
                            // HH-MM-SS
                            cell.setCellValue(timeFormat.format(date));
                        } else {
                            // ALL
                            cell.setCellValue(AllFormat.format(date));
                        }
                    }
                    if (o instanceof LocalDate) {
                        cell.setCellValue(((LocalDate) o).toString());
                    }
                    if (o instanceof LocalDateTime) {
                        final LocalDateTime localDateTime = (LocalDateTime) o;
                        String s = localDateTime.toString();
                        s = s.replace("T", " ");
                        s = s.substring(0, s.indexOf("."));
                        cell.setCellValue(s);
                    }
                    if (o instanceof LocalTime) {
                        final LocalTime localTime = (LocalTime) o;
                        String s1 = localTime.toString();
                        s1 = s1.substring(0, s1.indexOf("."));
                        cell.setCellValue(s1);
                    }
                } else if (o instanceof Double) {
                    // 小数
                    cell.setCellValue((Double) o);
                } else if (o instanceof String) {
                    // 字符串
                    cell.setCellValue((String) o);
                } else {
                    // 没有默认设置字符串格式
                    cell.setCellValue(String.valueOf(o));
                }
            }
        }
        // 4、写入到文件中
        String name = UidUtils.getUUID();
        final String path = FileUtils.genUploadFile(name + DEFAULT_FILE_SUFFIX);
        ExcelUtils.WriteFile(workbook, new File(path));
        return "upload" + File.separator + DateUtils.getDateByFormat(new Date(), DateUtils.YYYY_MM_DD) + File.separator + name + DEFAULT_FILE_SUFFIX;
    }

    /**
     * 判断是一个对象是否是时间类型
     *
     * @param o
     * @return boolean
     * @author LDB
     * @date 2023-02-19
     **/
    private static boolean isDate(Object o) {
        String type = o.getClass().getTypeName();
        if (StringUtils.isEmpty(type)) {
            return false;
        }
        return type.equals("java.time.LocalDate") || type.equals("java.time.LocalDateTime") || type.equals("java.time.LocalTime") || o instanceof Date;
    }


    public static List<Map<String, Object>> readDataBySheet(Sheet sheet, Map<Integer, String> fields, Integer startIdx) {
        List<Map<String, Object>> wrapDatas = new ArrayList<>();
        // 每个表的每一行
        for (Row row : sheet) {
            if (row.getRowNum() >= startIdx) {
                // 正常读取数据
                Map wrapRowData = new HashMap<String, Object>();
                for (Cell cell : row) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    cellRef.formatAsString();
                    final int columnIndex = cell.getColumnIndex();
                    final String fieldName = fields.get(columnIndex);
                    if (StringUtils.isNotBlank(fieldName)) {
                        final CellType cellType = cell.getCellType();
                        switch (cellType) {
                            case BLANK:
                                wrapRowData.put(fieldName, cell.getStringCellValue());
                            case STRING:
                                wrapRowData.put(fieldName, cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    wrapRowData.put(fieldName, cell.getDateCellValue());
                                } else {
                                    // 数值数据需要单独处理 数字可以转换的格式 字符串、时间、数字
                                    wrapRowData.put(fieldName, cell.getNumericCellValue());
                                }
                                break;
                            case BOOLEAN:
                                wrapRowData.put(fieldName, cell.getBooleanCellValue());
                                break;
                            case _NONE:
                                wrapRowData.put(fieldName, cell.getStringCellValue());
                                break;
                        }
                    }
                }
                wrapDatas.add(wrapRowData);
            }
        }
        return wrapDatas;
    }

    ;

    public static Map<Integer, String> readFieldsBySheet(Sheet sheet, Integer startIdx) {
        if (sheet == null) {
            throw new RuntimeException("要读取的工作表不存在");
        }
        final Row row = sheet.getRow(startIdx);
        if (row == null) {
            throw new RuntimeException("要读取的属性行不存在");
        }
        Map<Integer, String> wrapFields = new HashMap<>();
        // 获取属性的所有字段信息
        for (Cell cell : row) {
            if (cell.getCellComment() != null) {
                final Comment comment = cell.getCellComment();
                // 需要过滤的内容
                String filterStr = comment.getAuthor();
                final RichTextString string = comment.getString();
                string.clearFormatting();
                String content = HtmlUtil.cleanHtmlTag(string.getString());
                content = content.substring(filterStr.length());
                content = content.replaceAll("\n", "");
                content = content.replaceAll(":", "");
                wrapFields.put(cell.getColumnIndex(), content);
            }
        }
        return wrapFields;
    }

    /**
     * 通过文件读取数据
     *
     * @param file
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author LDB
     * @date 2023-02-18
     **/
    public static List<Map<String, Object>> readExcelByFile(File file) {
        // 使用文件导入比使用输入流导入要更快，因为用流就会需要缓存
        // 1、将文件写入到工作薄
        final Workbook workbook = ExcelUtils.getWorkbookByFile(file);
        // 2、陆续遍历每一行每一列
        // 包装后的对象字段  列索引 -> 属性信息
        Map<Integer, String> wrapFields = new HashMap<>();
        // 包装后的对象数据
        List<Map<String, Object>> wrapDatas = new ArrayList<>();
        // 获取字段和数据信息
        // 每一个工作表
        for (Sheet sheet : workbook) {
            wrapFields = readFieldsBySheet(sheet, DEFAULT_FIELD_ROW);
            wrapDatas.addAll(readDataBySheet(sheet, wrapFields, DEFAULT_DATA_START_ROW));
        }
        return wrapDatas;
    }


    /**
     * 是否xls
     *
     * @param file
     * @return boolean
     * @author LDB
     * @date 2023-02-17
     **/
    public static boolean isXls(File file) {
        return isXls(FileUtils.getSuffixByFile(file));
    }

    /**
     * 是否xls
     *
     * @param suffix 后缀
     * @return boolean
     * @author LDB
     * @date 2023-02-17
     **/
    public static boolean isXls(String suffix) {
        return XLS.equals(suffix);
    }

    /**
     * 是否xlsx
     *
     * @param file
     * @return boolean
     * @author LDB
     * @date 2023-02-17
     **/
    public static boolean isXlsx(File file) {
        return isXlsx(FileUtils.getSuffixByFile(file));
    }

    /**
     * 是否xlsx
     *
     * @param suffix
     * @return boolean
     * @author LDB
     * @date 2023-02-17
     **/
    public static boolean isXlsx(String suffix) {
        return XLSX.equals(suffix);
    }

    /**
     * 默认列样式
     *
     * @param workbook
     * @return org.apache.poi.ss.usermodel.CellStyle
     * @author LDB
     * @date 2023-02-17
     **/
    public static CellStyle defaultCellStyle(Workbook workbook) {
        // 声明全局样式
        final CellStyle globalCellStyle = workbook.createCellStyle();
        // 默认数据水平垂直居中对齐且带边框
        globalCellStyle.setAlignment(HorizontalAlignment.CENTER);
        globalCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        globalCellStyle.setBorderBottom(BorderStyle.THIN);
        globalCellStyle.setBorderLeft(BorderStyle.THIN);
        globalCellStyle.setBorderRight(BorderStyle.THIN);
        globalCellStyle.setBorderTop(BorderStyle.THIN);
        return globalCellStyle;
    }


    public static void main(String[] args) {

    }

}
