import java.util.List;

public class User implements Comparable<User>{

    private String userName;
    private String password;
    private int tokens;
    private int numberOfQuestSolved;
    private int numberOfQuestProposed;
    private List<Badge> badgeList;

    public User(String userName, String password, int tokens, int numberOfQuestSolved, int numberOfQuestProposed, List<Badge> badgeList) {
        this.userName = userName;
        this.password = password;
        this.tokens = tokens;
        this.numberOfQuestSolved = numberOfQuestSolved;
        this.numberOfQuestProposed = numberOfQuestProposed;
        this.badgeList = badgeList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public int getNumberOfQuestSolved() {
        return numberOfQuestSolved;
    }

    public void setNumberOfQuestSolved(int numberOfQuestSolved) {
        this.numberOfQuestSolved = numberOfQuestSolved;
    }

    public int getNumberOfQuestProposed() {
        return numberOfQuestProposed;
    }

    public void setNumberOfQuestProposed(int numberOfQuestProposed) {
        this.numberOfQuestProposed = numberOfQuestProposed;
    }

    public List<Badge> getBadgeList() {
        return badgeList;
    }

    public void setBadgeList(List<Badge> badgeList) {
        this.badgeList = badgeList;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.getTokens(), o.getTokens()) * -1;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tokens=" + tokens +
                ", numberOfQuestSolved=" + numberOfQuestSolved +
                ", numberOfQuestProposed=" + numberOfQuestProposed +
                ", badgeList=" + badgeList +
                '}';
    }
}
