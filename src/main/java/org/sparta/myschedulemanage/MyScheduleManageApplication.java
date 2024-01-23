package org.sparta.myschedulemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyScheduleManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyScheduleManageApplication.class, args);
    }

}
