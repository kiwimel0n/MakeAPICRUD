package org.sparta.myschedulemanage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;

@Entity
@Getter
@Setter
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

}
