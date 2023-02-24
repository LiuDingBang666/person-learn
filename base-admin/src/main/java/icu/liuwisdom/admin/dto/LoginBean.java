package icu.liuwisdom.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录接口封装对象
 *
 * @author Louis
 * @date Oct 29, 2018
 */
@Data
@ApiModel("登录表单")
@AllArgsConstructor
@NoArgsConstructor
public class LoginBean {
    @ApiModelProperty("用户名")
    private String account;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("验证码")
    private String captcha;

}
