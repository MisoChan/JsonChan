import com.launchpersimmonseeds.jsonchan.annotations.JsonObject;
import com.launchpersimmonseeds.jsonchan.annotations.JsonValue;

@JsonObject("cats")
public class TestChildEntity {
    @JsonValue(column = "ID")
    private String nekoID;
    @JsonValue(column = "nekoName")
    private String nekoName;

    public String getNekoID() {
        return nekoID;
    }

    public void setNekoID(String nekoID) {
        this.nekoID = nekoID;
    }

    public String getNekoName() {
        return nekoName;
    }

    public void setNekoName(String nekoName) {
        this.nekoName = nekoName;
    }

    public String getNekoage() {
        return nekoage;
    }

    public void setNekoage(String nekoage) {
        this.nekoage = nekoage;
    }

    @JsonValue(column = "nekoage")
    private String nekoage;

}
