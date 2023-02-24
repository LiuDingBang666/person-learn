package icu.liuwisdom.admin.dto;

import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.entity.SysRoleDept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("机构管理DTO")
public class SysDeptDto extends SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色机构信息")
    private List<SysRoleDept> sysRoleDept;
}
