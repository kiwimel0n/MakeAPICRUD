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

    @GetMapping("/list-all")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleManageService.getSchedules();
    }

    @GetMapping("/list/{id}")
    public List<ScheduleResponseDto> getScheduleById(@PathVariable final Long id) {
        return scheduleManageService.getScheduleInfo(id);
    }

    @PutMapping("/update/{id}")
    public ScheduleResponseDto updateSchedule(
            @PathVariable final Long id,
            @RequestBody final ScheduleRequestDto scheduleRequestDto
    ){
        return scheduleManageService.updateSchedule(id, scheduleRequestDto);
    }


    @DeleteMapping("/delete/{id}/{password}")
    public String deleteSchedule(@PathVariable final Long id, @PathVariable final int password) {
        return scheduleManageService.deleteSchedule(id, password);
    }

}
