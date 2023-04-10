import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingSystem {

    private static List<User> userList = new ArrayList<>();
    private static List<Quest> questsList = new ArrayList<>();

    public static List<Quest> getQuestsList() {
        return questsList;
    }

    public static void setQuestsList(List<Quest> questsList) {
        RankingSystem.questsList = questsList;
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        RankingSystem.userList = userList;
    }

    public void addQuest(User user, Quest quest){
        int index = -1;
        for(int i = 0; i < userList.size(); i++){
            if(user.getUserName().equals(userList.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("User not found!");
        }else{
            if(user.getTokens() >= quest.getTokens()){
                questsList.add(quest);

                user.setNumberOfQuestProposed(user.getNumberOfQuestProposed() + 1 );
                user.setTokens(user.getTokens()-quest.getTokens());

                List<Badge> badgeList = new ArrayList<>(user.getBadgeList());

                if(user.getNumberOfQuestProposed() == 2){
                    badgeList.add(Badge.NOVICE_QUEST_PROPOSER);
                }
                if(user.getNumberOfQuestProposed() == 5){
                    badgeList.add(Badge.INTERMEDIATE_QUEST_PROPOSER);
                }
                if(user.getNumberOfQuestProposed() == 10){
                    badgeList.add(Badge.MASTER_QUEST_PROPOSER);
                }
                user.setBadgeList(badgeList);
                userList.set(index,user);
            }else{
                System.out.println("User doesn't have enough tokens!");
            }
        }
    }

    public void solveQuest(User user, Quest quest){

        int index = -1;

        for(int i = 0; i < userList.size(); i++){
            if(user.getUserName().equals(userList.get(i).getUserName())) {
                index = i;
                break;
            }
        }

        int indexQuest = -1;

        for(int i = 0; i < questsList.size(); i++){
            if(quest.getName().equals(questsList.get(i).getName())) {
                indexQuest = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("User not found!");
        }else{
            if(indexQuest != -1){
                questsList.remove(indexQuest);

                user.setNumberOfQuestSolved(user.getNumberOfQuestSolved() + 1 );
                user.setTokens(user.getTokens()+quest.getTokens());

                List<Badge> badgeList = new ArrayList<>(user.getBadgeList());

                if(user.getNumberOfQuestSolved() == 2){
                    badgeList.add(Badge.NOVICE_QUEST_SOLVER);
                }
                if(user.getNumberOfQuestSolved() == 5){
                    badgeList.add(Badge.INTERMEDIATE_QUEST_SOLVER);
                }
                if(user.getNumberOfQuestSolved() == 10){
                    badgeList.add(Badge.MASTER_QUEST_SOLVER);
                }
                user.setBadgeList(badgeList);
                userList.set(index,user);
            }else{
                System.out.println("Quest not found!");
            }
        }
    }

    public void addUser(User user){

        int index = -1;
        for(int i = 0; i < userList.size(); i++){
            if(user.getUserName().equals(userList.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        if(index == -1){
            userList.add(user);
        }else{
            System.out.println("User already exists!");
        }
    }

    public void displayRanking(){
        Collections.sort(userList);
        System.out.println(userList);
    }

    public void displayRankingByBadge(Badge badge){

        List<User> users = new ArrayList<>(userList.stream().filter(user -> user.getBadgeList().contains(badge)).toList());
        Collections.sort(users);
        System.out.println(users);
    }
}
