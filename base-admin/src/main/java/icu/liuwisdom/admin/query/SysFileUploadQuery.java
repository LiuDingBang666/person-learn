package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件上传查询类
 *
 * @author ldb
 * @ClassName SysFileUploadQuery.java
 * @Data 2022-05-21 16:23
 */
@ApiModel("文件上传查询类-查询")
@Data
public class SysFileUploadQuery extends PageRequest implements Serializable {

    /**
     * 文件名
     */
    @ApiModelProperty("文件名")
    private String fileName;

    /**
     * 文件地址
     */
    @ApiModelProperty("文件地址")
    private String fileUrl;
}
