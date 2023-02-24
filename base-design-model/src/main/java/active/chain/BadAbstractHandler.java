package active.chain;

import com.alibaba.fastjson.JSON;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:11
 */

public class BadAbstractHandler extends AbstractHandler {
    @Override
    void handlerRequest(Email email) {
        if ("Bad".equals(email.getType())) {
            System.out.println("law handler:");
            System.out.println(JSON.toJSONString(email));
        }
        super.handlerRequest(email);
    }
}
