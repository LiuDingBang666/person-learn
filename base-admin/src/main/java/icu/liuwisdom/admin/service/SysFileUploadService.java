package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysFileUpload;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.query.SysFileUploadQuery;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 系统文件上传表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-05-21
 */
public interface SysFileUploadService extends IService<SysFileUpload> {
    /**
     * 单文件上传
     *
     * @param file
     * @return icu.liuwisdom.admin.entity.SysFileUpload
     * @author Ldb
     * @date 2022-05-21
     **/
    SysFileUpload fileUpload(MultipartFile file);

    /**
     * 多文件上传
     *
     * @param null
     * @return null
     * @author Ldb
     * @date 2022-05-21
     **/
    List<SysFileUpload> multipartFileUpload(List<MultipartFile> files);

    /**
     * 文件下载
     *
     * @param null
     * @return null
     * @author Ldb
     * @date 2022-05-21
     **/
    void fileDown(String url, HttpServletResponse response);

    /**
     * 文件删除
     *
     * @param null
     * @return null
     * @author Ldb
     * @date 2022-05-21
     **/
    Boolean fileDelete(String id);

    /**
     * 分页查询
     *
     * @param null
     * @return null
     * @author Ldb
     * @date 2022-05-21
     **/
    PageInfo<SysFileUpload> pageData(SysFileUploadQuery query);
}
