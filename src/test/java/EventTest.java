import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.Event;
import classes.User;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    User user1 = null;
    User test = null;
    Event event = null;

    @BeforeEach
    void prepare() {
        user1 = new User();
        user1.setUserId(1);
        user1.setUserName("user1");

        test = new User();
        test.setUserId(999);
        test.setUserName("testuser");

        event = new Event(user1, "Crying violently", "I dont fucking know anymore",
            "My basement", "01.01.2000, 12:00");
        event.addParticipator(test);
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