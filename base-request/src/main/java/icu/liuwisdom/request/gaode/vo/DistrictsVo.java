package icu.liuwisdom.request.gaode.vo;

import icu.liuwisdom.request.gaode.GaoResult;
import icu.liuwisdom.request.gaode.po.Districts;
import icu.liuwisdom.request.gaode.po.Suggestion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域Vo
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 22:28
 */
@Data
public class DistrictsVo extends GaoResult {
    /**
     * 建议结果
     *
     * @author LDB
     * @date 2022-07-25 22:30
     * @version 1.0
     */
    private Suggestion suggestion;

    /**
     * 行政区列表
     *
     * @author LDB
     * @date 2022-07-25 22:32
     * @version 1.0
     */
    private List<Districts> districts = new ArrayList<>();
}
