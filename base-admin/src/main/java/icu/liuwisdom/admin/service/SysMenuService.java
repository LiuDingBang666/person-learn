package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.query.SysMenuQuery;
import icu.liuwisdom.admin.vo.SysMenuVo;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysMenuService extends IService<SysMenu> {

    Boolean delete(List<String> records);

    List<SysMenuVo> findTree(String userName);

    List<SysMenuVo> buildTree(List<SysMenuVo> list);

    PageInfo<SysMenuVo> pageData(SysMenuQuery query);
}
