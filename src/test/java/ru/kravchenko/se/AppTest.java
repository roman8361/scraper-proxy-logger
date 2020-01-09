package ru.kravchenko.se;

import static org.junit.Assert.assertTrue;

import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private LoremIpsum loremIpsum = new LoremIpsum();
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void testForEach() {
        List<User> users = getUsersData();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    private List<User> getUsersData() {
        List<User> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName(loremIpsum.getName());
            result.add(user);
        }
        return result;

    }
}
