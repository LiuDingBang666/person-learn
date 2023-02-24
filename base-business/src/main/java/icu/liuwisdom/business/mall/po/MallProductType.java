package icu.liuwisdom.business.mall.po;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.business.mall.vo.MallProductVo;
import icu.liuwisdom.core.utils.tree.AbstractBaseTreePo;
import icu.liuwisdom.core.utils.tree.AbstractBaseTreeVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商城 分类信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@TableName("mall_product_type")
@ApiModel(value = "MallProductType对象", description = "商城 分类信息")
public class MallProductType extends AbstractBaseTreePo<MallProductTypeVo> implements Serializable {

    @ApiModelProperty("部门id")
    private String fkDeptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;

    @ApiModelProperty(value = "名称", required = true)
    @NotEmpty(message = "名称不能为空")
    private String name;


    @Override
    public MallProductTypeVo vo() {
        AbstractBaseTreeVo<MallProductTypeVo> vo = toVo();
        MallProductTypeVo res = new MallProductTypeVo();
        BeanUtil.copyProperties(vo, res);
        res.setDelFlag(this.delFlag);
        res.setName(this.name);
        res.setSort(this.sort);
        res.setFkDeptId(this.fkDeptId);
        res.setDeptName(this.deptName);
        return res;
    }
}
