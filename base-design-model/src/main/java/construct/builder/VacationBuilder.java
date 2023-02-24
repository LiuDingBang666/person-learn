package construct.builder;

/**
 * 假期建造者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 9:54
 */

public class VacationBuilder extends AbstractBuilder {
    /**
     * 生成一个建造者
     *
     * @author LDB
     * @date 2023-01-25 9:55
     * @version 1.0
     */
    Planner planner = new Planner();

    @Override
    AbstractBuilder buildDay(String day) {
        planner.setDay(day);
        return this;
    }

    @Override
    AbstractBuilder addHotel(String hotel) {
        planner.setHotel(hotel);
        return this;
    }

    @Override
    AbstractBuilder addReservation(String reservation) {
        planner.setReservation(reservation);
        return this;
    }

    @Override
    AbstractBuilder addSpecialEvent(String specialEvent) {
        planner.setSpecialEvent(specialEvent);
        return this;
    }

    @Override
    AbstractBuilder addTickets(String tickets) {
        planner.setTickets(tickets);
        return this;
    }

    @Override
    Planner getVacationPlanner() {
        return planner;
    }
}
