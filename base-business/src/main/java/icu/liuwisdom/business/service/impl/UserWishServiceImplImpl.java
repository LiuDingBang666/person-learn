package icu.liuwisdom.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import icu.liuwisdom.business.entity.UserWish;
import icu.liuwisdom.business.mapper.UserWishMapper;
import icu.liuwisdom.business.query.UserWishQuery;
import icu.liuwisdom.business.service.UserWishService;
import icu.liuwisdom.business.vo.UserWishVo;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * <p>
 * 用户愿望表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Service
public class UserWishServiceImplImpl extends BaseServiceImpl<UserWishMapper, UserWish, UserWishQuery, UserWishVo> implements UserWishService {
    @Resource
    UserWishMapper mapper;

    @Override
    public UserWish bestWish(String id) {
        val unSelectList = mapper.selectList(new LambdaQueryWrapper<UserWish>()
                .eq(UserWish::getFkUserId, id)
                .eq(UserWish::getIsImpl, 1));
        return unSelectList.isEmpty() ? new UserWish() : unSelectList.get(new Random().nextInt(unSelectList.size()));
    }

    @Override
    public List<UserWish> list(UserWishQuery query) {
        return mapper.selectList(new LambdaQueryWrapper<UserWish>()
                .eq(StringUtils.isNotEmpty(query.getFkUserId()), UserWish::getFkUserId, query.getFkUserId())
                .like(StringUtils.isNotEmpty(query.getName()), UserWish::getName, query.getName())
                .like(StringUtils.isNotEmpty(query.getContent()), UserWish::getContent, query.getContent())
                .eq(null != query.getIsSelected(), UserWish::getIsSelected, query.getIsSelected())
                .eq(null != query.getIsImpl(), UserWish::getIsImpl, query.getIsImpl())
                .eq(null != query.getIsPublish(), UserWish::getIsPublish, query.getIsPublish()));
    }

    @Override
    public Boolean selectWish(String id) {
        val wish = this.getById(id);
        if (Objects.isNull(wish)) {
            throw new BusinessException("愿望为空");
        }
        if (null != wish.getIsImpl() && wish.getIsImpl().equals(0)) {
            throw new BusinessException("该愿望已被实现");
        }
        if (null != wish.getIsSelected() && wish.getIsSelected().equals(1)) {
            throw new BusinessException("该愿望已被选择");
        }
        wish.setIsSelected(1);
        this.updateById(wish);
        return true;
    }

    @Override
    public Boolean hasSelected(String id) {
        return mapper.selectList(new LambdaQueryWrapper<UserWish>()
                .eq(UserWish::getFkUserId, id)
                .eq(UserWish::getIsSelected, 1)).size() > 0;
    }

    @Override
    public UserWishVo getById(String id) {
        return mapper.selectById(id);
    }

    @Override
    public Boolean confirm(String id) {
        val wish = this.getById(id);
        if (Objects.isNull(wish)) {
            throw new BusinessException("愿望为空");
        }
        if (null != wish.getIsImpl() && wish.getIsImpl().equals(0)) {
            throw new BusinessException("该愿望已被实现");
        }
        wish.setIsImpl(0);
        this.updateById(wish);
        return true;
    }

    @Override
    public Boolean canSelected(String id) {
        return mapper.selectList(new LambdaQueryWrapper<UserWish>()
                .eq(UserWish::getFkUserId, id)).size() < 5;
    }
}
