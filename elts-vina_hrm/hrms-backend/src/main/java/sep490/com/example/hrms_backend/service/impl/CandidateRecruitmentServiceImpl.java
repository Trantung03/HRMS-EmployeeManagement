package sep490.com.example.hrms_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sep490.com.example.hrms_backend.entity.CandidateRecruitment;
import sep490.com.example.hrms_backend.repository.CandidateRecruitmentRepository;
import sep490.com.example.hrms_backend.service.CandidateRecruitmentService;

import java.util.Optional;
@Service
@RequiredArgsConstructor

public class CandidateRecruitmentServiceImpl implements CandidateRecruitmentService {

    private final CandidateRecruitmentRepository candidateRecruitmentRepository;

    public Optional<CandidateRecruitment> findById(Long candidateRecruitmentId) {

        return candidateRecruitmentRepository.findById(candidateRecruitmentId);

    }
}
