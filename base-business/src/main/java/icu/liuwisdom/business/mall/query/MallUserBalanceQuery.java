package icu.liuwisdom.business.mall.query;
import icu.liuwisdom.core.page.PageRequest;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "MallUserBalanceQuery对象" , description = "商城 用户余额信息")
public class MallUserBalanceQuery extends PageRequest implements Serializable {

    @ApiModelProperty("用户id")
    private String fkUserId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("余额")
    private BigDecimal balance;

    @ApiModelProperty("余额类型 0=积分 1=余额")
    private Integer type;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;
}
