package cn.com.sina.alan;

import cn.com.sina.alan.a.out.SourceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SourceApplication.class)
@WebAppConfiguration
@DirtiesContext
public class SourceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
