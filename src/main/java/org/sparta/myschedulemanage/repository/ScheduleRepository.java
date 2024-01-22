package org.sparta.myschedulemanage.repository;

import org.sparta.myschedulemanage.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
