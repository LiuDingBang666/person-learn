package icu.liuwisdom.request.gaode.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议结果列表
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 22:22
 */
@Data
public class Suggestion {
    /**
     * 建议关键字列表
     *
     * @author LDB
     * @date 2022-07-25 22:23
     * @version 1.0
     */

    List<String> keywords = new ArrayList<>();

    /**
     * 建议城市列表
     *
     * @author LDB
     * @date 2022-07-25 22:23
     * @version 1.0
     */

    List<String> cites = new ArrayList<>();
}
