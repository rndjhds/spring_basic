package com.basic.spring_basic.scan;

import com.basic.spring_basic.AutoAppConfig;
import com.basic.spring_basic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Map<String, AutoAppConfig> beansOfType = ac.getBeansOfType(AutoAppConfig.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key =" + key + " value = " + ac.getBean(key));
        }
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
