package active.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单项
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;
}
