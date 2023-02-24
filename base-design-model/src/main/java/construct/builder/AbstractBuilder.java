package construct.builder;

/**
 * 抽象计划建造者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 9:53
 */

public abstract class AbstractBuilder {
    abstract AbstractBuilder buildDay(String day);

    abstract AbstractBuilder addHotel(String hotel);

    abstract AbstractBuilder addReservation(String reservation);

    abstract AbstractBuilder addSpecialEvent(String specialEvent);

    abstract AbstractBuilder addTickets(String tickets);

    abstract Planner getVacationPlanner();
}
