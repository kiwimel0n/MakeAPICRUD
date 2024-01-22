package org.sparta.myschedulemanage.dto;

//@Value에 포함된 어노테이션
//@Getter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@FieldDefaults(makeFinal = true, accessLevel = AccessLevel.PRIVATE)

import lombok.AllArgsConstructor;
import lombok.Getter;

public record ScheduleRequestDto(String taskName, String contents, String manager, int password){ }

// 하기 전에 밑에 다 지우고
// 이건 좀 남겨 놔야겠음 공부긴해서

/*public class ScheduleRequestDto(){
    String taskName;
    String contents;
    String manger;
}

//이런 방식이 있고 마지막으로 발전된 문법이


@Getter
@AllArgsConstructor
public class ScheduleRequestDto(){
    String taskName;
    String contents;
    String manager;
}
//이것이 두번째고


@Getter
public class ScheduleRequestDto(){
    private final String taskName;
    private final String contents;
    private final String manager;
}*/
//이게 맨 첫번째였지?*/
