package classes;

public class EventMember {
    private User member;
    private String role;

    public EventMember(User user, String role) {
        this.member = user;
        this.role = role;
    }

    public User getMember() {
        return member;
    }

    public String getRole() {
        return role;
    }
}
