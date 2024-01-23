package org.sparta.myschedulemanage.dto;

//@Value 에 포함된 어노테이션
//@Getter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@FieldDefaults(makeFinal = true, accessLevel = AccessLevel.PRIVATE)

public record ScheduleRequestDto(
        String taskName,
        String contents,
        String manager,
        int password
){

}


/*@value
public class ScheduleRequestDto(){
    String taskName;
    String contents;
    String manger;
}




@Getter
@AllArgsConstructor
public class ScheduleRequestDto(){
    String taskName;
    String contents;
    String manager;
}



@Getter
public class ScheduleRequestDto(){
    private final String taskName;
    private final String contents;
    private final String manager;
}*/

