import com.launchpersimmonseeds.jsonchan.jsonbuilder.JsonBuilder;
import org.junit.Test;

public class TestMethod {
    @Test
    public void generateJson(){
        JsonBuilder jsonBuilder = new JsonBuilder();
        TestEntity te = new TestEntity();
        te.setKey("nekochan");
        te.setValue(1);
        te.getNekolist().add(te);
        te.getNekolist().add(te);
        String str = jsonBuilder.toJson(te);
        System.out.println(str);
    }
}
