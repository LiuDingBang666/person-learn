package icu.liuwisdom.business.mall.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import icu.liuwisdom.business.mall.po.MallProductActivity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 产品活动
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallProductActivityVo对象", description = "商城 产品活动")
public class MallProductActivityVo extends MallProductActivity implements Serializable {

}
