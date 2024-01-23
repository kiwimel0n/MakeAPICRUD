package org.sparta.myschedulemanage.entity;

import jakarta.persistence.*;
import lombok.*;
import org.sparta.myschedulemanage.dto.ScheduleRequestDto;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = false)
    private String taskName;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "manager", nullable = false)
    private String manager;
    @Column(name = "password", nullable = false)
    private int password;




    public static Schedule of(ScheduleRequestDto requestDto) {
        return Schedule.builder()
                .taskName(requestDto.taskName())
                .contents(requestDto.contents())
                .manager(requestDto.manager())
                .password(requestDto.password())
                .build();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.taskName = requestDto.taskName();
        this.contents = requestDto.contents();
        this.manager = requestDto.manager();
    }

}

