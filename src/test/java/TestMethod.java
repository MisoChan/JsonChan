import com.launchpersimmonseeds.jsonchan.jsonbuilder.JsonBuilder;
import org.junit.Test;

public class TestMethod {
    @Test
    public void generateJson() throws IllegalAccessException {
        JsonBuilder jsonBuilder = new JsonBuilder();
        TestEntity te = new TestEntity();
        TestChildEntity tea = new TestChildEntity();
        TestChildEntity tea2 = new TestChildEntity();
        te.setKey("nekochan");
        te.setValue(1);
        tea.setNekoID("MATATABI");
        tea.setNekoName("SUPER_CAT");
        tea.setNekoage("660");
        te.getNekolist().add(tea);
        tea2.setNekoID("MUSASABI");
        tea2.setNekoName("SUPER_GREAT_CAT");
        tea2.setNekoage(null);
        te.getNekolist().add(tea2);
        String str = jsonBuilder.toJson(te);
        System.out.println(str);
    }
}
