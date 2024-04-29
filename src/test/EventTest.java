package src.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.classes.Event;
import src.main.classes.User;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    User user1;
    User test;
    Event event;

    @BeforeEach
    void prepare() {
        System.out.println("beforeeach");
        user1 = new User();
        user1.setUserId(1);
        user1.setUserName("user1");
        System.out.println("user created");

        User test = new User();
        test.setUserName("testuser");
        test.setUserId(999);
        System.out.println("testuser created");

        event = new Event(user1, "Crying violently", "I dont fucking know anymore",
            "My basement", "01.01.2000, 12:00");
        System.out.println("event created");

        event.addParticipator(test);
        System.out.println("testuser added");
        System.out.println(event.getParticipants().contains(test));
    }

    @AfterEach
    void cleanUp() {
        user1 = null;
        test = null;
        event = null;
    }

    @Test
    void addParticipator() {
        assertTrue(event.getParticipants().contains(test));
    }

    @Test
    void removeParticipator() {
        event.removeParticipator(test);

        assertFalse(event.getParticipants().contains(test));
    }

    @Test
    void newHost() {
        event.newHost(user1, test);

        assertEquals(test, event.getHost());
    }
}