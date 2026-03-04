package sep490.com.example.hrms_backend.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import sep490.com.example.hrms_backend.dto.RecruitmentDto;
import sep490.com.example.hrms_backend.dto.RecruitmentGraphResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface RecruitmentService {
    List<RecruitmentDto> getRecruitmentList(String search, String sortField, String sortOrder);
    public Page<RecruitmentDto> getRecruitmentPage(int page,
                                                   int size,
                                                   String search,
                                                   String sortField,
                                                   String sortOrder);
    RecruitmentDto getRecruitmentDtoById(long id);
    RecruitmentDto createRecruitment( RecruitmentDto recruitmentDto);
    RecruitmentDto editRecruitment(Long id, RecruitmentDto recruitmentDto);
    void updateRecruitmentStatus();
    List<RecruitmentGraphResponse> getGraphData(LocalDateTime fromDate, LocalDateTime toDate);
}
