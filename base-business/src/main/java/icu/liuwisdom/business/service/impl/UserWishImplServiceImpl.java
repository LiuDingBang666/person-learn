package icu.liuwisdom.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.liuwisdom.business.entity.UserWishImpl;
import icu.liuwisdom.business.mapper.UserWishImplMapper;
import icu.liuwisdom.business.service.UserWishImplService;
import icu.liuwisdom.business.service.UserWishService;
import icu.liuwisdom.business.vo.UserWishVo;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 愿望实现表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Service
public class UserWishImplServiceImpl extends ServiceImpl<UserWishImplMapper, UserWishImpl> implements UserWishImplService {
    @Resource
    UserWishImplMapper mapper;

    @Resource
    UserWishService userWishService;

    @Override
    public List<UserWishVo> mine(String id) {
        val implList = mapper.selectList(new LambdaQueryWrapper<UserWishImpl>().eq(UserWishImpl::getFkUserId, id));
        val list = implList.stream().map(val -> userWishService.getById(val.getFkWishId())).collect(Collectors.toList());
        return list;
    }
}
