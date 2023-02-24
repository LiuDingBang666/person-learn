package icu.liuwisdom.request.gaode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import icu.liuwisdom.request.gaode.mapper.DistrictMapper;
import icu.liuwisdom.request.gaode.po.District;
import icu.liuwisdom.request.gaode.po.Districts;
import icu.liuwisdom.request.gaode.query.DistrictQuery;
import icu.liuwisdom.request.gaode.service.DistrictService;
import icu.liuwisdom.request.gaode.vo.DistrictsVo;
import icu.liuwisdom.utils.UidUtils;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 省份区域信息表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-07-25
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements DistrictService {
    @Resource
    DistrictMapper mapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(DistrictsVo vo) {
        // 请求到的数据为空
        if (Objects.isNull(vo)) {
            return;
        }
        // 获取区域信息
        List<Districts> districts = vo.getDistricts();
        List<Districts> districtList = new ArrayList<>();
        // 递归传入父id(所有id都交由用户自行定义)
        // 先设置所有一级的区域id
        for (Districts district : districts) {
            val parentId = UidUtils.getUUID();
            district.setId(parentId);
            // 如果有子区域，则递归设置
            if (!district.getDistricts().isEmpty()) {
                injectId(district.getDistricts(), parentId, districtList);
            }
            districtList.add(district);
        }
        if (!districtList.isEmpty()) {
            List<District> list = districtList.stream().map(val -> val.toPo()).collect(Collectors.toList());
            this.saveBatch(list);
        }
    }

    @Override
    public List<District> tree(DistrictQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        val wrapper = new LambdaQueryWrapper<District>()
                .eq(StringUtils.isNotEmpty(query.getId()), District::getId, query.getId())
                .eq(StringUtils.isNotEmpty(query.getParentId()), District::getParentId, query.getParentId())
                .eq(StringUtils.isNotEmpty(query.getCityCode()), District::getCityCode, query.getCityCode())
                .eq(StringUtils.isNotEmpty(query.getAdcode()), District::getAdcode, query.getAdcode())
                .like(StringUtils.isNotEmpty(query.getName()), District::getName, query.getName())
                .like(StringUtils.isNotEmpty(query.getPolyline()), District::getPolyline, query.getPolyline())
                .like(StringUtils.isNotEmpty(query.getCenter()), District::getCenter, query.getCenter())
                .eq(StringUtils.isNotEmpty(query.getLevel()), District::getLevel, query.getLevel());
        return mapper.selectList(wrapper);
    }


    /**
     * 生成子区域id数据
     *
     * @param districts    子区域列表
     * @param parentId     父id
     * @param districtList 要新增的区域数据列表
     * @author LDB
     * @date 2022-07-25
     **/
    private void injectId(List<Districts> districts, String parentId, List<Districts> districtList) {
        for (Districts district : districts) {
            String currentId = UidUtils.getUUID();
            district.setId(currentId);
            district.setParentId(parentId);
            districtList.add(district);
            if (!district.getDistricts().isEmpty()) {
                injectId(district.getDistricts(), currentId, districtList);
            }
        }
    }
}
