package icu.liuwisdom.request.gaode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.request.gaode.po.District;
import icu.liuwisdom.request.gaode.po.Districts;
import icu.liuwisdom.request.gaode.query.DistrictQuery;
import icu.liuwisdom.request.gaode.vo.DistrictsVo;

import java.util.List;

/**
 * <p>
 * 省份区域信息表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-07-25
 */
public interface DistrictService extends IService<District> {

    void insert(DistrictsVo vo);

    List<District> tree(DistrictQuery query);
}
