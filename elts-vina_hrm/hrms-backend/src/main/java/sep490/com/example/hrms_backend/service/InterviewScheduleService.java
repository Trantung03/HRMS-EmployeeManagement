package sep490.com.example.hrms_backend.service;

import jakarta.validation.Valid;
import sep490.com.example.hrms_backend.dto.InterviewScheduleDTO;
import sep490.com.example.hrms_backend.dto.InterviewScheduleDTO2;
import sep490.com.example.hrms_backend.entity.InterviewSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface InterviewScheduleService {

    InterviewScheduleDTO getInterviewByCandidateRecruitmentId(Long id);
    InterviewScheduleDTO createInterviewSchedule(@Valid InterviewScheduleDTO interviewScheduleDTO, Long employeeId);
    InterviewSchedule save(InterviewSchedule schedule);
    List<InterviewScheduleDTO> getAllInterviewSchedule(Long empId);
    void sendInterviewEmail(String to, String cc, String username, LocalDateTime interviewTime);
    InterviewScheduleDTO editInterview(Long id, InterviewScheduleDTO interviewScheduleDTO);
    InterviewScheduleDTO getInterviewById(@Valid Long id);
    void updateStatus(Long id, String status);
    void updateResult(Long id, String result);
    InterviewScheduleDTO editInterview2(Long id, @Valid InterviewScheduleDTO2 interviewScheduleDTO);

}
