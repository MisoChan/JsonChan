import com.launchpersimmonseeds.jsonchan.annotations.JsonObject;
import com.launchpersimmonseeds.jsonchan.annotations.JsonValue;

import java.util.ArrayList;
import java.util.List;
@JsonObject(name = "TEST")
public class TestEntity {
    @JsonValue(column = "key")
    private String key;
    @JsonValue(column = "intValue")
    private int value;

    private String neko;
    @JsonValue(column = "nekolist")
    private List<TestChildEntity> nekolist = new ArrayList<>();

    public List<TestChildEntity> getNekolist() {
        return nekolist;
    }

    public void setNekolist(List<TestChildEntity> nekolist) {
        this.nekolist = nekolist;
    }

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



}

