package icu.liuwisdom.business.mall.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import icu.liuwisdom.business.mall.po.MallOrderProcess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 订单进展信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallOrderProcessVo对象", description = "商城 订单进展信息")
public class MallOrderProcessVo extends MallOrderProcess implements Serializable {

}
