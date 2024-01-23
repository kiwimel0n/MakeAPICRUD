package org.sparta.myschedulemanage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.myschedulemanage.entity.Schedule;
import org.sparta.myschedulemanage.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MyScheduleManageApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ScheduleRepository scheduleRepository;


    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("할일 생성 성공")
    void test1(){
        Schedule schedule = new Schedule();
        schedule.setTaskName("산책");
        schedule.setContents("카페를 들리러가면서 마실다녀오기");
        schedule.setManager("김민상");
        schedule.setPassword(1234);

        em.persist(schedule);

    }

    @Test
    void contextLoads() {
    }

}
