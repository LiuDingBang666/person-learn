package icu.liuwisdom.business.mall.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import icu.liuwisdom.business.mall.po.MallUserBalance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 用户余额信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallUserBalanceVo对象", description = "商城 用户余额信息")
public class MallUserBalanceVo extends MallUserBalance implements Serializable {

}
