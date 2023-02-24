package icu.liuwisdom.admin.mapper;

import icu.liuwisdom.admin.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.liuwisdom.admin.query.SysMenuQuery;
import icu.liuwisdom.admin.vo.SysMenuVo;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过用户id查询角色菜单
     *
     * @param userId 用户id
     * @return java.util.List<icu.liuwisdom.admin.po.SysMenu>
     * @author Ldb
     * @date 2022-06-03
     **/
    List<SysMenu> selectMenusByUserId(String userId);

    List<SysMenuVo> pageData(SysMenuQuery query);
}
