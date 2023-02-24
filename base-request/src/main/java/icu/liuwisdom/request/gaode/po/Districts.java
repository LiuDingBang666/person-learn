package icu.liuwisdom.request.gaode.po;

import icu.liuwisdom.core.modal.BaseModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 行政区信息
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 22:25
 */
@Data
public class Districts extends BaseModel {
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

    /**
     * 下级行政区列表，包含district元素
     *
     * @author LDB
     * @date 2022-07-25 22:28
     * @version 1.0
     */

    private List<Districts> districts = new ArrayList<>();


    public District toPo() {
        District po = new District();
        po.setId(this.id);
        po.setParentId(this.parentId);
        po.setAdcode(this.adcode);
        po.setCityCode(this.cityCode);
        po.setLevel(this.level);
        po.setPolyline(this.polyline);
        po.setCenter(this.center);
        po.setName(this.name);
        return po;
    }
}
