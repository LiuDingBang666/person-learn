package icu.liuwisdom.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.LoginBean;
import icu.liuwisdom.admin.dto.SysUserDto;
import icu.liuwisdom.admin.entity.SysMenu;
import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.entity.SysUserRole;
import icu.liuwisdom.admin.mapper.SysMenuMapper;
import icu.liuwisdom.admin.mapper.SysUserMapper;
import icu.liuwisdom.admin.mapper.SysUserRoleMapper;
import icu.liuwisdom.admin.query.SysUserQuery;
import icu.liuwisdom.admin.security.JwtAuthenticatioToken;
import icu.liuwisdom.admin.service.SysLoginLogService;
import icu.liuwisdom.admin.service.SysMenuService;
import icu.liuwisdom.admin.service.SysRoleService;
import icu.liuwisdom.admin.service.SysUserService;
import icu.liuwisdom.admin.utils.AuthCodeUtil;
import icu.liuwisdom.admin.utils.SecurityUtils;
import icu.liuwisdom.admin.utils.SendSmsUtil;
import icu.liuwisdom.admin.vo.SysMenuVo;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.constant.SysConstants;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.core.page.PageRequest;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import icu.liuwisdom.utils.PoiUtils;
import icu.liuwisdom.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
@Slf4j
public class SysUserServiceImplImpl extends BaseServiceImpl<SysUserMapper, SysUser, SysUserQuery, SysUserVo> implements SysUserService {
    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    RedisUtil redisUtil;

    @Resource
    SysMenuMapper sysMenuMapper;

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysMenuService sysMenuService;

    @Resource
    SysUserRoleServiceImpl sysUserRoleService;

    @Resource
    SysUserRoleMapper sysUserRoleMapper;

    @Resource
    SysLoginLogService sysLoginLogService;

    @Override
    public SysUser findByName(String name) {
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(StringUtils.isNotEmpty(name), SysUser::getName, name));
        return sysUser;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    /**
     * 根据用户名查询用户权限
     *
     * @param name 用户名
     * @return java.util.Set<java.lang.String>
     * @author Ldb
     * @date 2022-06-02
     **/
    @Override
    public Set<String> findPermissions(String name) {
        SysUser user = findByName(name);
        List<SysMenu> sysMenus = name.equals("admin") ? sysMenuService.list() : sysMenuMapper.selectMenusByUserId(user.getId());
        Set<String> data = sysMenus.stream().filter(i -> !i.getType().equals(null) && i.getType().equals(2)).map(i -> i.getPerms()).collect(Collectors.toSet());
        return data;
    }

    /**
     * @param userId 根据用户id查询用户角色
     * @return icu.liuwisdom.admin.vo.SysUserVo
     * @author Ldb
     * @date 2022-06-02
     **/
    @Override
    public List<SysRole> findUserRoles(String userId) {
        SysUser user = this.getById(userId);
        List<SysRole> data = sysRoleService.findByName(user.getName());
        return data;
    }

    @Override
    public LambdaQueryWrapper<SysUser> wrapper(SysUserQuery query) {
        return super.wrapper(query)
                .eq(StringUtils.isNotEmpty(query.getName()), SysUser::getName, query.getName())
                .eq(StringUtils.isNotEmpty(query.getNickName()), SysUser::getNickName, query.getNickName())
                .eq(StringUtils.isNotEmpty(query.getEmail()), SysUser::getEmail, query.getEmail())
                .eq(StringUtils.isNotEmpty(query.getMobile()), SysUser::getMobile, query.getMobile())
                .eq(query.getStatus() != null, SysUser::getStatus, query.getStatus())
                .eq(StringUtils.isNotEmpty(query.getDeptId()), SysUser::getDeptId, query.getDeptId());
    }

    @Override
    public PageInfo<SysUser> pageData(SysUserQuery query) {
        return this.listPage(query);
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        return createUserExcelFile(this.list());
    }

    public static File createUserExcelFile(List<?> records) {
        if (records == null) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");
        for (int i = 0; i < records.size(); i++) {
            SysUser user = (SysUser) records.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnIndex + 1; j++) {
                row.createCell(j);
            }
            columnIndex = 0;
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            row.getCell(++columnIndex).setCellValue(user.getEmail());
            row.getCell(++columnIndex).setCellValue(user.getStatus());
            row.getCell(++columnIndex).setCellValue(user.getAvatar());
            row.getCell(++columnIndex).setCellValue(user.getCreateBy());
            row.getCell(++columnIndex).setCellValue(user.getCreateTime().toString());
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateTime().toString());
        }
        return PoiUtils.createExcelFile(workbook, "download_user");
    }

    @Override
    public SysUser save(SysUserVo registerBean) {
        SysUser po = new SysUser();
        if (StringUtils.isEmpty(po.getNickName())) {
            po.setNickName(po.getName());
        }

        BeanUtils.copyProperties(registerBean, po);
        this.save(po);
        return po;
    }

    @Override
    public boolean removeById(Serializable id) {
        val user = this.getById(id);
        // 移除
        redisUtil.del(user.getName());
        return super.removeById(id);
    }

    @Override
    /**
     * 根据用户名查询用户信息
     * @author LDB
     * @date 2022-06-08
     * @param name
     * @return icu.liuwisdom.admin.vo.SysUserVo
     **/ public SysUserVo findAllByName(String name) {
        SysUserVo sysUserVo = sysUserMapper.selectByName(name);
        if (Objects.isNull(sysUserVo)) {
            return new SysUserVo();
        }
        // 如果是admin，则拥有所有菜单
        if (name.equals(SysConstants.ADMIN)) {
            sysUserVo.setSysMenu(sysMenuService.list());
        }
        List<SysMenuVo> menuVo = sysUserVo.getSysMenu().stream().map(i -> i.toVo()).collect(Collectors.toList());
        // 查询用户菜单树
        List<SysMenuVo> menuTree = sysMenuService.buildTree(menuVo);
        sysUserVo.setSysMenuTree(menuTree);
        // 查询权限
        Set<String> permissions = findPermissions(sysUserVo.getName());
        sysUserVo.setPermission(permissions);
        return sysUserVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser save(SysUserDto dto) {
        if (StringUtils.isNotEmpty(dto.getMobile())) {
            val user = this.findByPhone(dto.getMobile());
            if (Objects.nonNull(user)) {
                throw new BusinessException("该手机号已被绑定，请切换手机号");
            }
        }
        if (StringUtils.isEmpty(dto.getNickName())) {
            dto.setNickName(dto.getName());
        }
        SysUser po = new SysUser();
        BeanUtils.copyProperties(dto, po);
        this.save(po);
        dto.setId(po.getId());
        // 新增用户角色信息
        insertUserRole(dto);
        return po;
    }

    /**
     * 新增用户角色信息
     *
     * @param dto 表单
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-07-17
     **/
    private Boolean insertUserRole(SysUserDto dto) {
        if (null == dto.getUserRole() || dto.getUserRole().isEmpty()) {
            return true;
        }
        List<SysUserRole> userRoles = dto.getUserRole().stream().map(val -> {
            val.setUserId(dto.getId());
            return val;
        }).collect(Collectors.toList());
        return sysUserRoleService.saveBatch(userRoles);
    }

    @Override
    public boolean save(SysUser entity) {
        if (StringUtils.isNotEmpty(entity.getMobile())) {
            val user = this.findByPhone(entity.getMobile());
            if (Objects.nonNull(user)) {
                throw new BusinessException("该手机号已被绑定，请切换手机号");
            }
        }
        if (StringUtils.isEmpty(entity.getNickName())) {
            entity.setNickName(entity.getName());
        }
        // 新增缓存
        String userName = entity.getName();
        val user = this.findAllByName(userName);
        redisUtil.set(SysConstants.USER_INFO + userName, JSON.toJSONString(user), 60 * 60 * 3);
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser updateById(SysUserDto dto) {
        SysUser po = new SysUser();
        BeanUtils.copyProperties(dto, po);
        if (StringUtils.isNotEmpty(po.getMobile())) {
            val user = this.findByPhone(po.getMobile());
            if (Objects.nonNull(user) && !user.getId().equals(dto.getId())) {
                throw new BusinessException("该手机号已被其他用户绑定，请切换手机号");
            }
        }
        this.updateById(po);
        dto.setId(po.getId());
        // 移除原先的用户角色信息
        removeUserRoleByUserId(dto.getId());
        // 新增用户角色信息
        insertUserRole(dto);
        val user = this.findAllByName(po.getName());
        // 更新缓存
        redisUtil.set(SysConstants.USER_INFO + po.getName(), JSON.toJSONString(user), 60 * 60 * 3);
        return po;
    }

    @Override
    public SysUserVo getById(String id) {
        return sysUserMapper.selectById(id);
    }


    /**
     * 手机验证码登录
     *
     * @param phone
     * @param code
     * @return icu.liuwisdom.admin.security.JwtAuthenticatioToken
     * @author LDB
     * @date 2022-12-09
     **/
    @Override
    public JwtAuthenticatioToken phoneCodeLogin(String phone, String code, AuthenticationManager authenticationManager, HttpServletRequest request) {
        if (StringUtils.isEmpty(phone)) {
            throw new BusinessException("手机号不存在");
        }
        if (StringUtils.isEmpty(code)) {
            throw new BusinessException("验证码不存在");
        }
        String metaCode = redisUtil.get(phone, String.class);
        if (StringUtils.isEmpty(metaCode)) {
            throw new BusinessException("验证码已过期或不存在");
        }
        if (!metaCode.equals(code)) {
            throw new BusinessException("验证码错误，请重新输入");
        }
        SysUser user = findByPhone(phone);
        JwtAuthenticatioToken token = null;
        if (Objects.isNull(user)) {
            user = new SysUser();
            // todo 用户名唯一-手机号
            user.setName(phone);
            user.setNickName(phone);
            user.setPassword(phone);
            user.setMobile(phone);
            user.setStatus(1);
            user.setUserType(0);
            this.save(user);
        } else {
            // 账号锁定
            if (user.getStatus() == 0) {
                sysLoginLogService.add(new LoginBean(user.getName(), user.getPassword(), ""), "账号已被锁定,请联系管理员", request);
                throw new BusinessException("账号已被锁定,请联系管理员");
            }
        }
        token = SecurityUtils.login(request, user.getName(), user.getPassword(), authenticationManager);
        return token;
    }

    /**
     * 通过手机号查询用户信息
     *
     * @param phone
     * @return icu.liuwisdom.admin.entity.SysUser
     * @author LDB
     * @date 2022-12-09
     **/
    public SysUser findByPhone(String phone) {
        return sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(StringUtils.isNotEmpty(phone), SysUser::getMobile, phone));
    }

    /**
     * 获取验证码
     *
     * @param phone
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-09
     **/
    @Override
    public Boolean getValidCode(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new BusinessException("手机号不能为空");
        }
        // 如果验证码还未过期，则直接返回
        String val = redisUtil.get(phone, String.class);
        if (StringUtils.isNotEmpty(val)) {
            return true;
        }
        String code = AuthCodeUtil.getCode();
        SendSmsUtil.sendSms(code, phone);
        redisUtil.set(phone, code, 60);
        return true;
    }

    /**
     * 通过用户id删除用户角色信息
     *
     * @param id 用户id
     * @author LDB
     * @date 2022-07-17
     **/
    private void removeUserRoleByUserId(String id) {
        sysUserRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, id));
    }
}
