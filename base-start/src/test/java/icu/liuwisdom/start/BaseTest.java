package icu.liuwisdom.start;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-11 19:52
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTest {
    @Test
    public void t1() {
        Set set = new HashSet<AUser>();
        set.add(new AUser("ldb", "111", 12));
        set.add(new AUser("ldb", "111", 12));
        set.add(new AUser("ldb2", "111", 12));
        System.out.println(set.stream().collect(Collectors.toList()));
    }
}

@Data
@AllArgsConstructor
class AUser {
    String userName;
    String phone;
    Integer age;

    @Override
    public int hashCode() {
        return Objects.hash(userName, phone, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            return true;
        }
        if (!(obj instanceof AUser)) {
            return false;
        }
        AUser now = (AUser) obj;
        return userName.equals(now.userName) && age.equals(now.age) && phone.equals(now.phone);
    }
}
