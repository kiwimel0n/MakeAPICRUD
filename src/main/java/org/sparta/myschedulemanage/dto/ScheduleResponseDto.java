package org.sparta.myschedulemanage.dto;


import lombok.Builder;

@Builder
public record ScheduleResponseDto(
        String taskName,
        String contents,
        String manager,
        String createdAt,
        String modifiedAt
) {

}


// Schedule extends Timestamped(정보 id , 패스워드 , 매니저이름, 하일내용, 할일 이름)