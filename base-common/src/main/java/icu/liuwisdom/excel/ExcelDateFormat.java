package icu.liuwisdom.excel;

/**
 * Excel常用时间格式
 *
 * @author LDB
 * @version 1.0
 * @date 2023-02-17 21:14
 */

public interface ExcelDateFormat {
    String YMD = "yyyy-m-d";

    String ALL = ExcelDateFormat.YMD + " " + ExcelDateFormat.HMS;

    String HMS = "hh:mm:ss";

    String HM = "hh:mm";

    String MDYHM = "m/d/yy h:mm";
}
