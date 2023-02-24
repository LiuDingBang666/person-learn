package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysDeptDto;
import icu.liuwisdom.admin.mapper.SysDeptMapper;
import icu.liuwisdom.admin.mapper.SysRoleDeptMapper;
import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.entity.SysRoleDept;
import icu.liuwisdom.admin.query.SysDeptQuery;
import icu.liuwisdom.admin.service.SysDeptService;
import icu.liuwisdom.admin.vo.SysDeptVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysDeptServiceImplImpl extends BaseServiceImpl<SysDeptMapper, SysDept, SysDeptQuery, SysDeptVo> implements SysDeptService {
    @Resource
    SysDeptMapper sysDeptMapper;

    @Resource
    SysRoleDeptServiceImpl sysRoleDeptService;

    @Resource
    SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)

    public Boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    /**
     * 查询机构树
     *
     * @return java.util.List<icu.liuwisdom.admin.vo.SysDeptVo>
     * @author Ldb
     * @date 2022-06-01
     **/
    @Override
    public List<SysDeptVo> findTree() {
        List<SysDeptVo> data = this.list().stream().map(SysDept::toVo).collect(Collectors.toList());
        List<SysDeptVo> parent = new ArrayList<>();
        // 获取一级机构树
        for (SysDeptVo sysDept : data) {
            if (StringUtils.isEmpty(sysDept.getParentId()) || sysDept.getParentId().equals(0)) {
                sysDept.setLevel(0);
                parent.add(sysDept);
            }
        }
        // 获取子级机构
        findChildren(parent, data);
        return parent;
    }


    /**
     * 分页查询机构
     *
     * @param query 查询类
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.admin.po.SysMenu>
     * @author LDB
     * @date 2022-07-10
     **/
    @Override
    public PageInfo<SysDept> pageData(SysDeptQuery query) {
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<SysDept>()
                .like(!StringUtils.isEmpty(query.getName()), SysDept::getName, query.getName())
                .orderByAsc(SysDept::getOrderNum);
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return PageInfo.of(sysDeptMapper.selectList(wrapper));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysDept save(SysDeptDto dto) {
        SysDept po = new SysDept();
        BeanUtils.copyProperties(dto, po);
        this.save(po);
        // 新增角色部门信息
        dto.setId(po.getId());
        insertRoleDept(dto);
        return po;
    }

    /**
     * 新增部门角色信息
     *
     * @param dto 表单
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-07-17
     **/
    private Boolean insertRoleDept(SysDeptDto dto) {
        if (null == dto.getSysRoleDept() || dto.getSysRoleDept().isEmpty()) {
            return true;
        }
        // 新增角色机构信息
        List<SysRoleDept> roleDept = dto.getSysRoleDept().stream().map(val -> {
            val.setDeptId(dto.getId());
            return val;
        }).collect(Collectors.toList());
        return sysRoleDeptService.saveBatch(roleDept);
    }

    /**
     * 通过部门id移除该部门下所有角色信息
     *
     * @param deptId 部门id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-07-17
     **/
    private void removeRoleDeptByDeptId(String deptId) {
        sysRoleDeptMapper.delete(new LambdaQueryWrapper<SysRoleDept>()
                .eq(SysRoleDept::getDeptId, deptId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysDept updateById(SysDeptDto dto) {
        // 修改部门信息信息
        SysDept po = new SysDept();
        BeanUtils.copyProperties(dto, po);
        this.updateById(po);
        // 移除所有部门角色信息
        removeRoleDeptByDeptId(dto.getId());
        // 新增部门角色信息
        insertRoleDept(dto);
        return po;
    }

    @Override
    public SysDeptVo getById(String id) {
        return sysDeptMapper.selectById(id);
    }

    /**
     * 查询机构子树
     *
     * @param data 一级机构
     * @param list 源数据列表
     * @author Ldb
     * @date 2022-06-01
     **/
    private void findChildren(List<SysDeptVo> data, List<SysDeptVo> list) {
        for (SysDeptVo parent : data) {
            List<SysDeptVo> children = new ArrayList<>();
            for (SysDeptVo sysDept : list) {
                if (!StringUtils.isEmpty(sysDept.getParentId()) && sysDept.getParentId().equals(parent.getId())) {
                    sysDept.setParentName(parent.getName());
                    sysDept.setLevel(parent.getLevel() + 1);
                    children.add(sysDept);
                }
            }
            parent.setChildren(children);
            if (!children.isEmpty()) {
                findChildren(children, list);
            }
        }
    }
}
