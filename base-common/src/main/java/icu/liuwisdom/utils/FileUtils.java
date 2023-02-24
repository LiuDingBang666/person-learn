package icu.liuwisdom.utils;

import icu.liuwisdom.config.SystemProductConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * 文件相关操作
 *
 * @author ldb
 */
@Component
public class FileUtils {
    /**
     * 本地文件路径
     *
     * @author LDB
     * @date 2023-02-19 10:13
     * @version 1.0
     */
    public static final String LOCAL_FILE_PATH = System.getProperty("user.dir") + File.separator + FileUtils.FILE + File.separator;
    /**
     * 上传路径
     *
     * @author LDB
     * @date 2023-02-19 10:17
     * @version 1.0
     */
    public static final String UPLOAD = "upload";
    /**
     * 文件文件夹路径
     *
     * @author LDB
     * @date 2023-02-19 10:33
     * @version 1.0
     */
    public static final String FILE = "file";
    /**
     * 临时路径
     *
     * @author LDB
     * @date 2023-02-19 10:17
     * @version 1.0
     */
    public static final String TEMP = "temp";
    /**
     * 模板路径
     *
     * @author LDB
     * @date 2023-02-19 10:17
     * @version 1.0
     */
    public static final String TEMPLATE = "template";
    /**
     * 系统当前环境
     *
     * @author LDB
     * @date 2023-02-19 10:15
     * @version 1.0
     */
    public static final String OS = System.getProperty("os.name");
    /**
     * 线上上传路径（线上）
     */
    @Resource
    public SystemProductConfig productConfig;


    /**
     * 文件上传名拼接
     *
     * @param fileName
     * @return java.lang.String
     * @author Ldb
     * @date 2021-12-06
     **/
    public static String fileNameSplicing(String fileName) {
        return UidUtils.getUUID() + fileName.substring(fileName.lastIndexOf("."));
    }


    /**
     * 下载文件
     *
     * @param response
     * @param file
     * @param newFileName
     */
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取txt文件的内容
     *
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String readFile(File file) {
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                //使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 递归删除文件
     *
     * @param file
     */
    public static void deleteFile(File file) {
        // 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
        if (file.isDirectory()) {
            // 获取子文件/目录
            File[] subFiles = file.listFiles();
            // 遍历该目录
            for (File subFile : subFiles) {
                // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除.
                // 如果这是一个非空目录, 多次递归清空其内容后再删除
                deleteFile(subFile);
            }
        }
        // 删除空目录或文件
        file.delete();
    }

    /**
     * 获取文件上传路径
     *
     * @param
     * @return java.lang.String
     * @author Ldb
     * @date 2022-05-21
     **/
    public static String getTemplatePath() {
        try {
            return new File(LOCAL_FILE_PATH + TEMPLATE).getCanonicalPath() + File.separator;
        } catch (IOException e) {
            throw new RuntimeException("获取模板文件路径失败");
        }
    }

    /**
     * 根据文件名生成一个上传文件路径
     * @author LDB
     * @date 2023-02-19
     * @param fileName
     * @return java.lang.String
     **/
    public static String genUploadFile(String fileName) {
        // 获取当前时间
        String time = DateUtils.getDateByFormat(new Date(), DateUtils.YYYY_MM_DD);
        // 最终的文件路径
        File dest = new File(FileUtils.getUploadPath() + time, fileName);
        // 判断文件父目录是否存在,不存在则创建一个
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        // 如果该文件存在，则先强制删除
        if (dest.exists()) {
            deleteFile(dest);
        }
        try {
            dest.createNewFile();
            return dest.getCanonicalPath();
        } catch (Exception e) {
            throw new RuntimeException("生成上传文件路径失败");
        }
    }

    public static String getTempPath() {
        try {
            return new File(LOCAL_FILE_PATH + TEMP).getCanonicalPath() + File.separator;
        } catch (IOException e) {
            throw new RuntimeException("获取临时文件路径失败");
        }
    }

    /**
     * 获取文件上传路径
     *
     * @param
     * @return java.lang.String
     * @author Ldb
     * @date 2022-05-21
     **/
    public static String getUploadPath() {
        try {
            return new File(LOCAL_FILE_PATH + UPLOAD).getCanonicalPath() + File.separator;
        } catch (IOException e) {
            throw new RuntimeException("获取文件上传路径失败");
        }
    }

    /**
     * 通过路径创建文件
     *
     * @param path 文件路径
     * @return java.io.File
     * @author LDB
     * @date 2023-02-17
     **/
    public static File createFileByPath(String path) {
        File newFile = null;
        try {
            newFile = new File(path);
            if (!newFile.exists()) {
                if (newFile.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    newFile.createNewFile();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("创建文件/文件夹失败!");
        }
        return newFile;
    }

    public static File createTempFileByPath(String path) {
        File newFile = null;
        try {
            newFile = File.createTempFile(path, getSuffixByName(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newFile.deleteOnExit();
        return newFile;
    }

    /**
     * 获取文件后缀名
     *
     * @param file
     * @return java.lang.String
     * @author LDB
     * @date 2023-02-19
     **/
    public static String getSuffixByFile(File file) {
        return getSuffixByName(file.getName());
    }


    /**
     * 获取文件后缀名
     *
     * @param name
     * @return java.lang.String
     * @author LDB
     * @date 2023-02-19
     **/
    public static String getSuffixByName(String name) {
        return name.substring(name.lastIndexOf("."));
    }

    public static void main(String[] args) {
//        System.out.println(getUploadPath());
//        System.out.println(getUploadPath());
    }
}
