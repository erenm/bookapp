package com.bookapp.crud;

import static org.assertj.core.api.Assertions.assertThat;

import com.bookapp.crud.controller.QueryControllerTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    @Autowired
    private QueryControllerTests queryController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(queryController).isNotNull();
    }
}
