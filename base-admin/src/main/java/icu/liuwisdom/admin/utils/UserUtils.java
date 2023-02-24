package icu.liuwisdom.admin.utils;

import com.alibaba.fastjson.JSON;
import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.service.SysUserService;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.constant.SysConstants;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.utils.RedisUtil;
import icu.liuwisdom.utils.StringUtils;
import lombok.val;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * 用户工具类
 *
 * @author LDB
 * @version 1.0
 * @date 2022-09-04 15:14
 */

@Component
public class UserUtils {
    @Resource
    SysUserService userService;

    @Resource
    RedisUtil redisUtil;

    private static UserUtils instance;

    @PostConstruct
    public void getInstance() {
        UserUtils.instance = this;
    }

    /**
     * 获取当前用户信息
     *
     * @return icu.liuwisdom.admin.vo.SysUserVo
     * @author ldb
     * @date 2022-09-04
     **/
    public SysUserVo getCurrentUser() {
        val userName = SecurityUtils.getUsername();
        if (StringUtils.isBlank(userName)) {
            throw new BusinessException("当前用户不存在");
        }
        SysUserVo user = null;
        val cache = redisUtil.get(SysConstants.USER_INFO + userName);
        if (Objects.nonNull(cache)) {
            user = JSON.parseObject(String.valueOf(cache), SysUserVo.class);
        } else {
            user = Optional.of(userName).map(val -> userService.findAllByName(userName)).get();
            // 3个小时内刷新一次
            redisUtil.set(SysConstants.USER_INFO + userName, JSON.toJSONString(user), 60 * 60 * 3);
        }
        return user;
    }

    /**
     * 获取当前用户
     *
     * @return icu.liuwisdom.admin.vo.SysUserVo
     * @author LDB
     * @date 2022-12-06
     **/
    public static SysUserVo getUser() {
        return instance.getCurrentUser();
    }


    /**
     * 获取当前用户所属部门信息
     *
     * @return icu.liuwisdom.admin.entity.SysDept
     * @author LDB
     * @date 2023-01-27
     **/
    public static SysDept getDept() {
        SysUserVo user = getUser();
        return user.getDept();
    }

}
