package active.chain;

import lombok.Data;

import java.util.Objects;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:08
 */
@Data
public abstract class AbstractHandler {
    /**
     * 下一个请求
     *
     * @author LDB
     * @date 2023-01-25
     * @param null
     * @return null
     **/
    AbstractHandler next;

    /**
     * 处理请求的方法
     *
     * @author LDB
     * @date 2023-01-25 10:09
     * @version 1.0
     */
    void handlerRequest(Email email) {
        // 如果下一个不为空，则继续处理请求
        if (Objects.nonNull(next)) {
            next.handlerRequest(email);
        }
    }

    ;
}
