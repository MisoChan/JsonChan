import java.util.List;

public class TestEntity {

    private String key;

    private int value;

    private String neko;

    private List<TestEntity> nekolist;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNeko() {
        return neko;
    }

    public void setNeko(String neko) {
        this.neko = neko;
    }

    public List<TestEntity> getNekolist() {
        return nekolist;
    }

    public void setNekolist(List<TestEntity> nekolist) {
        this.nekolist = nekolist;
    }
}

