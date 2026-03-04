package sep490.com.example.hrms_backend.service;

import sep490.com.example.hrms_backend.dto.CandidateDto;
import sep490.com.example.hrms_backend.dto.CandidateResponseDTO;

import java.util.List;

public interface CandidateService {
    void saveOrUpdateCandidateByPhone(CandidateDto dto, Long recruitmentId);
    List<CandidateResponseDTO> getCandidatesByRecruitmentId(Long recruitmentId);
    void saveCandidate(CandidateDto candidateDto);
}
