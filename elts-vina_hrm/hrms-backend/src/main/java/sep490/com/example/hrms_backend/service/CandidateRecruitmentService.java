package sep490.com.example.hrms_backend.service;

import sep490.com.example.hrms_backend.entity.CandidateRecruitment;

import java.util.Optional;

public interface CandidateRecruitmentService {
    public Optional<CandidateRecruitment> findById(Long candidateRecruitmentId);
}
