package construct.builder;

import com.alibaba.fastjson.JSON;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 9:58
 */

public class Test {
    public static void main(String[] args) {
        AbstractBuilder builder = new VacationBuilder();
        Planner planner = builder
                .addHotel("假日酒店")
                .buildDay("2020-01-01")
                .addSpecialEvent("打篮球")
                .addTickets("飞机票").getVacationPlanner();
        System.out.println(JSON.toJSONString(planner));
    }
}
