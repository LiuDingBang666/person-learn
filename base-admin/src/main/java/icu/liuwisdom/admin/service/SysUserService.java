package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysUserDto;
import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.query.SysUserQuery;
import icu.liuwisdom.admin.security.JwtAuthenticatioToken;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.core.page.PageRequest;
import icu.liuwisdom.core.service.BaseService;
import org.springframework.security.authentication.AuthenticationManager;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysUserService extends BaseService<SysUser, SysUserQuery, SysUserVo> {

    /**
     * 通过用户名称查询用户信息
     *
     * @param name
     * @return icu.liuwisdom.admin.entity.SysUser
     * @author LDB
     * @date 2022-12-09
     **/
    SysUser findByName(String name);

    /**
     * 批量删除信息
     *
     * @param records
     * @return boolean
     * @author LDB
     * @date 2022-12-09
     **/
    boolean delete(List<String> records);

    /**
     * 通过用户名查询用户权限
     *
     * @param name
     * @return java.util.Set<java.lang.String>
     * @author LDB
     * @date 2022-12-09
     **/
    Set<String> findPermissions(String name);

    /**
     * 通过用户id查询用户角色
     *
     * @param userId
     * @return java.util.List<icu.liuwisdom.admin.entity.SysRole>
     * @author LDB
     * @date 2022-12-09
     **/
    List<SysRole> findUserRoles(String userId);

    /**
     * 分页查询用户信息
     *
     * @param query
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.admin.entity.SysUser>
     * @author LDB
     * @date 2022-12-09
     **/
    PageInfo<SysUser> pageData(SysUserQuery query);

    /**
     * 导出用户
     *
     * @param pageRequest
     * @return java.io.File
     * @author LDB
     * @date 2022-12-09
     **/
    File createUserExcelFile(PageRequest pageRequest);

    /**
     * 新增用户
     *
     * @param registerBean
     * @return icu.liuwisdom.admin.entity.SysUser
     * @author LDB
     * @date 2022-12-09
     **/
    SysUser save(SysUserVo registerBean);

    /**
     * 通过用户名查询所有信息
     *
     * @param name
     * @return icu.liuwisdom.admin.vo.SysUserVo
     * @author LDB
     * @date 2022-12-09
     **/
    SysUserVo findAllByName(String name);

    /**
     * 新增用户信息
     *
     * @param dto
     * @return icu.liuwisdom.admin.entity.SysUser
     * @author LDB
     * @date 2022-12-09
     **/
    SysUser save(SysUserDto dto);

    /**
     * 修改用户信息
     *
     * @param dto
     * @return icu.liuwisdom.admin.entity.SysUser
     * @author LDB
     * @date 2022-12-09
     **/
    SysUser updateById(SysUserDto dto);

    /**
     * 通过id查询用户信息
     *
     * @param id
     * @return icu.liuwisdom.admin.vo.SysUserVo
     * @author LDB
     * @date 2022-12-09
     **/
    SysUserVo getById(String id);

    /**
     * 手机号验证码登录
     *
     * @param phone
     * @param code
     * @return icu.liuwisdom.admin.security.JwtAuthenticatioToken
     * @author LDB
     * @date 2022-12-09
     **/
    JwtAuthenticatioToken phoneCodeLogin(String phone, String code, AuthenticationManager authenticationManager, HttpServletRequest request);

    /**
     * 通过手机号获取验证码
     *
     * @param phone
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-09
     **/
    Boolean getValidCode(String phone);
}
