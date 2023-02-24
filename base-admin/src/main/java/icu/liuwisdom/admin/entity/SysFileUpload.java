package icu.liuwisdom.admin.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 系统文件上传表
 * </p>
 *
 * @author ldb
 * @since 2022-05-21
 */
@Data
@ApiModel("文件上传")
public class SysFileUpload extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 排序（升序）
     */
    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String remarks;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty(" 是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;


}
