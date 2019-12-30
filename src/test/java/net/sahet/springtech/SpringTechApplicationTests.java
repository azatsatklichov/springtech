package net.sahet.springtech;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTechApplicationTests {

	public static final String VATINFO_URI = "http://localhost:9999/api/rate";

	@Test
	public void contextLoads() {
	}

}
