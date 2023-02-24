package icu.liuwisdom.business.mall.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import icu.liuwisdom.business.mall.po.MallUserBalanceWater;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 用户余额流水信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallUserBalanceWaterVo对象", description = "商城 用户余额流水信息")
public class MallUserBalanceWaterVo extends MallUserBalanceWater implements Serializable {

}
