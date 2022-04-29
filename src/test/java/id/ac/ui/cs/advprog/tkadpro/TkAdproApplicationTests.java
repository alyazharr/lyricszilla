package id.ac.ui.cs.advprog.tkadpro;

import id.ac.ui.cs.advprog.tkadpro.controller.BaseController;
import id.ac.ui.cs.advprog.tkadpro.service.PlayGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TkAdproApplicationTests {
    @Autowired
    private BaseController myController;

    @Autowired
    private PlayGameService myService;

    @Test
    void contextLoads() {
        assertThat(myController).isNotNull();
        assertThat(myService).isNotNull();
    }
}