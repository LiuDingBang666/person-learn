package icu.liuwisdom.request.gaode.po;

import icu.liuwisdom.core.modal.BaseModel;
import lombok.Data;

/**
 * 行政区信息
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 22:25
 */
@Data
public class District extends BaseModel {
    /**
     * 主键id
     *
     * @author LDB
     * @date 2022-07-25 22:46
     * @version 1.0
     */

    private String id;
    /**
     * 上级id
     *
     * @author LDB
     * @date 2022-07-25 22:46
     * @version 1.0
     */

    private String parentId;
    /**
     * 城市编码
     *
     * @author LDB
     * @date 2022-07-25 22:25
     * @version 1.0
     */
    private String cityCode;
    /**
     * 区域编码
     *
     * @author LDB
     * @date 2022-07-25 22:25
     * @version 1.0
     */

    private String adcode;
    /**
     * 行政区名称
     *
     * @author LDB
     * @date 2022-07-25 22:26
     * @version 1.0
     */

    private String name;
    /**
     * 行政区边界坐标点
     *
     * @author LDB
     * @date 2022-07-25 22:26
     * @version 1.0
     */

    private String polyline;
    /**
     * 区域中心点
     *
     * @author LDB
     * @date 2022-07-25 22:26
     * @version 1.0
     */

    private String center;

    /**
     * 行政区划级别
     * <p>
     * <p>
     * country:国家  province:省份（直辖市会在province和city显示） city:市（直辖市会在province和city显示） district:区县 street:街道
     * <p>
     *
     * <p>
     *
     * <p>
     *
     * <p>
     *
     * @author LDB
     * @date 2022-07-25 22:27
     * @version 1.0
     */

    private String level;


    public Districts toVo() {
        Districts vo = new Districts();
        vo.setId(this.id);
        vo.setParentId(this.parentId);
        vo.setCityCode(this.cityCode);
        vo.setAdcode(this.adcode);
        vo.setName(this.name);
        vo.setPolyline(this.polyline);
        vo.setCenter(this.center);
        vo.setLevel(this.level);
        return vo;
    }
}
