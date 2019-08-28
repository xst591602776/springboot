import com.ebchinatech.search.Application;
import com.ebchinatech.search.mapper.MaydayMapper;
import com.ebchinatech.search.model.Mayday;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MaydayTest {
    @Autowired
    private MaydayMapper maydayMapper;

    @Test
    public void test() {
        Mayday mayday = new Mayday();
        mayday.setContent("asda");
        maydayMapper.insert(mayday);
    }

    @Test
    public void testSel() {
        Mayday mayday = new Mayday();
        mayday.setContent("");
        mayday.setTitle("");

        System.out.println(maydayMapper.findByNameAndPassword(mayday, 0, 5));
    }

}
