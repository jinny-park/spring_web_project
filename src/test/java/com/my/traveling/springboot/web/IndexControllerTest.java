package com.my.traveling.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() { // 스프링 시큐리티 의존성을 없애야 함..안 그러면 로그인화면부터 떠서 테스팅 안됨
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        System.out.println(body);
        //then
        assertThat(body).contains("<h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>");
    }
}