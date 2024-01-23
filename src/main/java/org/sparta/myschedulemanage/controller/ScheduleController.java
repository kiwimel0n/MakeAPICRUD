package org.sparta.myschedulemanage.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.myschedulemanage.dto.ScheduleRequestDto;
import org.sparta.myschedulemanage.dto.ScheduleResponseDto;
import org.sparta.myschedulemanage.service.ScheduleManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleManageService scheduleManageService;

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
        return scheduleManageService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleManageService.getSchedules();
    }


    @GetMapping("/schedule/{id}")
    public List<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return scheduleManageService.getScheduleInfo(id);
    }

    @PutMapping("/schedule/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto){
        return scheduleManageService.updateSchedule(id, scheduleRequestDto);
    }


    @DeleteMapping("/schedule/{id}")
    public Long deleteSchedule(@PathVariable Long id, @RequestParam int password){
        return scheduleManageService.deleteSchedule(id, password);
    }

}
