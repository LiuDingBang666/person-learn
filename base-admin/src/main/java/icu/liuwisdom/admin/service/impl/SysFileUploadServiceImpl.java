package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysFileUpload;
import icu.liuwisdom.admin.mapper.SysFileUploadMapper;
import icu.liuwisdom.admin.query.SysFileUploadQuery;
import icu.liuwisdom.admin.service.SysFileUploadService;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.utils.DateUtils;
import icu.liuwisdom.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统文件上传表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-05-21
 */
@Service
@Slf4j
public class SysFileUploadServiceImpl extends ServiceImpl<SysFileUploadMapper, SysFileUpload> implements SysFileUploadService {

    @Resource
    SysFileUploadMapper mapper;

    @Override
    public SysFileUpload fileUpload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new BusinessException("文件为空");
        }
        // 获取文件名
        String fileName = FileUtils.fileNameSplicing(file.getOriginalFilename());
        // 获取当前时间
        String time = DateUtils.getDateByFormat(new Date(), DateUtils.YYYY_MM_DD);
        // 最终的文件路径
        File dest = new File(FileUtils.getUploadPath() + time + "/", fileName);
        // 判断文件父目录是否存在,不存在则创建一个
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        SysFileUpload data = new SysFileUpload();
        try {
            // 新增文件上传记录
            data.setFileName(file.getOriginalFilename());
            data.setFileUrl("upload/" + time + "/" + fileName);
            data.setDescription(dest.getCanonicalPath());
            data.setCreateTime(LocalDateTime.now());
            data.setRemarks(file.getContentType());
            this.save(data);
            //文件传输
            file.transferTo(dest);
        } catch (Exception e) {
            throw new BusinessException("上传失败," + e.getMessage());
        }
        return data;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<SysFileUpload> multipartFileUpload(List<MultipartFile> files) {
        if (files.isEmpty()) {
            throw new BusinessException("上传文件为空");
        }
        List<SysFileUpload> data = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                data.add(fileUpload(file));
            }
        } catch (Exception e) {
            throw new BusinessException("多文件上传失败," + e.getMessage());
        }
        return data;
    }


    @Override
    public void fileDown(String url, HttpServletResponse response) {
        if (url == null) {
            throw new BusinessException("文件路径为空");
        }
        try {
            // 文件验证
            File file = new File(FileUtils.getUploadPath() + url);
            if (!file.exists()) {
                throw new BusinessException("文件不存在");
            }
            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(url, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            // 如果设置此请求头，则为下载
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean fileDelete(String id) {
        SysFileUpload data = mapper.selectById(id);
        mapper.deleteById(id);
        File file = new File(data.getFileUrl());
        FileUtils.deleteFile(file);
        return true;
    }

    @Override
    public PageInfo<SysFileUpload> pageData(SysFileUploadQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysFileUpload> wrapper = new LambdaQueryWrapper<SysFileUpload>().like(StringUtils.isNotEmpty(query.getFileName()), SysFileUpload::getFileName, query.getFileName()).like(StringUtils.isNotEmpty(query.getFileUrl()), SysFileUpload::getFileUrl, query.getFileUrl());
        List<SysFileUpload> data = mapper.selectList(wrapper);
        return PageInfo.of(data);
    }
}
