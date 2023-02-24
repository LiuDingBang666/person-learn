package icu.liuwisdom.admin.dto;

import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.entity.SysUserRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统用户DTO")
public class SysUserDto extends SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户角色信息")
    private List<SysUserRole> userRole;

}
