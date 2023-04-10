public class Quest {

    private String name;
    private String description;
    private String difficulty;
    private int tokens;

    public Quest(String name, String description, String difficulty, int tokens) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.tokens = tokens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
