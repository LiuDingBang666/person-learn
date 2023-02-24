package icu.liuwisdom.admin.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统配置表")
public class SysConfig extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据值
     */
    @ApiModelProperty("数据值")
    private String value;

    /**
     * 标签名
     */
    @ApiModelProperty("标签名")
    private String label;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

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
    @ApiModelProperty("是否删除")
    @TableLogic
    private Integer delFlag;


}
