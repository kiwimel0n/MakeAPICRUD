package org.sparta.myschedulemanage.service;

import lombok.RequiredArgsConstructor;
import org.sparta.myschedulemanage.dto.ScheduleRequestDto;
import org.sparta.myschedulemanage.dto.ScheduleResponseDto;
import org.sparta.myschedulemanage.entity.Schedule;
import org.sparta.myschedulemanage.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleManageService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto){
        Schedule schedule = Schedule.of(requestDto);

        scheduleRepository.save(schedule);
        return createResponse(schedule);
    }

    // 할일 목록 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByModifiedAtDesc()
                .stream()
                .map(this::createResponse)
                .toList();

    }

    /**
     * 할 일 정보를 조회합니다.
     * @param id 조회할 할 일의 ID
     * @return 할 일 정보
     */
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> getScheduleInfo(Long id) {
        return scheduleRepository.findById(id)
                .stream()
                .map(this::createResponse)
                .toList();
    }

    /**
     * 할 일 정보를 수정합니다.
     * @param id 수정할 할 일 ID
     * @param requestDto 수정할 정보
     * @return 수정된 할 일 정보
     */
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findScheduleByIdIfExists(id);

        checkPasswordValidity(requestDto.password(), schedule.getPassword());

        schedule.update(requestDto);
        return createResponse(schedule);
    }

    // 선택한 할일 삭제 기능

    @Transactional
    public Long deleteSchedule(Long id, int password) {
        Schedule schedule = findScheduleByIdIfExists(id);

        checkPasswordValidity(password, schedule.getPassword());

        scheduleRepository.delete(schedule);
        return schedule.getId();
    }

    //  id에 해당하는 정보가 존재하는지 확인
    private Schedule findScheduleByIdIfExists(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }
    private void checkPasswordValidity(int inputPassword, int storedPassword) {
        boolean isCorrect = inputPassword == storedPassword;
        if (!isCorrect) {
            throw new IllegalArgumentException("비밀번호가 틀려요!");
        }
    }
    private ScheduleResponseDto createResponse(Schedule schedule) {
        return ScheduleResponseDto.builder()
                .taskName(schedule.getTaskName())
                .contents(schedule.getContents())
                .manager(schedule.getManager())
                .createdAt(schedule.getCreatedAt().toString())
                .build();
    }
}
