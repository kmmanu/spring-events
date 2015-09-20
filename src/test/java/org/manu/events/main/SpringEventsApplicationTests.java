package org.manu.events.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.manu.events.main.SpringEventsApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringEventsApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class SpringEventsApplicationTests {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testJspWithEl() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port, String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue("Wrong body:\n" + entity.getBody(),
                entity.getBody().contains("/resources/text.txt"));
    }

}
