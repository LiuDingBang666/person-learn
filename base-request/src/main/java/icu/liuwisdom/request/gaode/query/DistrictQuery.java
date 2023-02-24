package icu.liuwisdom.request.gaode.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 区域查询类
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-26 15:28
 */
@Data
@ApiModel("区域查询类")
public class DistrictQuery extends PageRequest implements Serializable {
    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("上级id")
    private String parentId;


    @ApiModelProperty("城市编码")
    private String cityCode;

    @ApiModelProperty("区域编码")
    private String adcode;

    @ApiModelProperty("行政区名称")
    private String name;


    @ApiModelProperty("行政区边界坐标点")
    private String polyline;


    @ApiModelProperty("区域中心点")
    private String center;

    @ApiModelProperty("country:国家  province:省份（直辖市会在province和city显示） city:市（直辖市会在province和city显示） district:区县 street:街道")
    private String level;
}
