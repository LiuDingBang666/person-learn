package icu.liuwisdom.request.gaode;

import lombok.Data;

/**
 * 高德数据结果
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 15:56
 */
@Data
public class GaoResult {
    /**
     * 返回结果状态值
     *
     * @author LDB
     * @date 2022-07-25 22:12
     * @version 1.0
     */

    private String status;
    /**
     * 返回状态说明
     *
     * @author LDB
     * @date 2022-07-25 22:12
     * @version 1.0
     */

    private String info;
    /**
     * 状态码
     *
     * @author LDB
     * @date 2022-07-25 22:12
     * @version 1.0
     */
    private String infocode;
    /**
     * 查询个数
     *
     * @author LDB
     * @date 2022-07-25 22:29
     * @version 1.0
     */
    private String count;

}
