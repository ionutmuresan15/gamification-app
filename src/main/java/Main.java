import java.util.List;

public class Main {
    public static void main(String[] args) {

        RankingSystem  rankingSystem = new RankingSystem();

        User user = new User("Ionut","12345",100,4,1, List.of(Badge.NOVICE_QUEST_SOLVER));
        User user2 = new User("Razvan","45678",500,5,2, List.of(Badge.NOVICE_QUEST_PROPOSER,Badge.NOVICE_QUEST_SOLVER,Badge.INTERMEDIATE_QUEST_SOLVER));
        User user3 = new User("Dan","1111",300,9,4, List.of(Badge.NOVICE_QUEST_PROPOSER,Badge.NOVICE_QUEST_SOLVER,Badge.INTERMEDIATE_QUEST_SOLVER));

        Quest quest = new Quest("quest1","aaaaa","medium",200);
        Quest quest2 = new Quest("quest2","bbbbb","easy",100);

        rankingSystem.addUser(user);
        rankingSystem.addUser(user2);
        rankingSystem.addUser(user3);

        rankingSystem.addQuest(user,quest);
        rankingSystem.solveQuest(user,quest);

        rankingSystem.addQuest(user2,quest2);
        rankingSystem.solveQuest(user2,quest2);

        rankingSystem.displayRanking();
        rankingSystem.displayRankingByBadge(Badge.NOVICE_QUEST_PROPOSER);
    }
}
