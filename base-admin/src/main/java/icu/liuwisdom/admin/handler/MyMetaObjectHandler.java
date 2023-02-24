package icu.liuwisdom.admin.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import icu.liuwisdom.admin.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * mybatis 自动填充控制器
 * 填充基本字段信息
 *
 * @author ldb
 * @ClassName MyMetaObjectHandler.java
 * @Data 2022-06-03 10:54
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        val user = UserUtils.getUser();
        this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class);
        if (Objects.nonNull(user)) {
            this.strictInsertFill(metaObject, "createBy", () -> StringUtils.isNotEmpty(user.getNickName()) ? user.getNickName() : "", String.class);
            this.strictInsertFill(metaObject, "fkCreateUserId", () -> user.getId(), String.class);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        val user = UserUtils.getUser();
        this.strictUpdateFill(metaObject, "lastUpdateTime", () -> LocalDateTime.now(), LocalDateTime.class);
        if (Objects.nonNull(user)) {
            this.strictUpdateFill(metaObject, "lastUpdateBy", () -> StringUtils.isNotEmpty(user.getNickName()) ? user.getNickName() : "", String.class);
            this.strictUpdateFill(metaObject, "fkUpdateUserId", () -> user.getId(), String.class);
        }
    }
}
