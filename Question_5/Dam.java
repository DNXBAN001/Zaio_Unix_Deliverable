
public class Dam {

    private String name;
    private String fsc;
    private String level;

    public Dam(String name, String fsc, String level) {
        this.name = name;
        this.fsc = fsc;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name.trim() + " " + this.fsc.trim() + " " + this.level.trim();
    }
}