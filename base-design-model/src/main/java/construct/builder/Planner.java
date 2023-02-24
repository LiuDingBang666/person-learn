package construct.builder;

import lombok.Data;

/**
 * 计划类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 9:51
 */
@Data
public class Planner {
    // 天
    String day;
    // 旅馆
    String hotel;
    // 车票
    String tickets;
    // 房间
    String reservation;
    // 特殊安排
    String specialEvent;
}
