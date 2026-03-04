package sep490.com.example.hrms_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sep490.com.example.hrms_backend.dto.CandidateDto;
import sep490.com.example.hrms_backend.dto.CandidateResponseDTO;
import sep490.com.example.hrms_backend.entity.Candidate;
import sep490.com.example.hrms_backend.entity.CandidateRecruitment;
import sep490.com.example.hrms_backend.entity.Recruitment;
import sep490.com.example.hrms_backend.enums.CandidateStatus;
import sep490.com.example.hrms_backend.exception.ResourceNotFoundException;
import sep490.com.example.hrms_backend.mapper.CandidateMapper;
import sep490.com.example.hrms_backend.repository.CandidateRecruitmentRepository;
import sep490.com.example.hrms_backend.repository.CandidateRepository;
import sep490.com.example.hrms_backend.repository.RecruitmentRepository;
import sep490.com.example.hrms_backend.service.CandidateService;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    private final  RecruitmentRepository recruitmentRepository;

    private final CandidateRecruitmentRepository candidateRecruitmentRepository;

    public boolean checkCandidateByEmail(String email) {
        return candidateRepository.existsByEmail(email);
    }


    public void saveOrUpdateCandidateByPhone(CandidateDto dto, Long recruitmentId) {
        Candidate candidate = candidateRepository.findByPhoneNumber(dto.getPhoneNumber())
                .orElse(null);

        if (candidate == null) {
            // Nếu ứng viên chưa tồn tại → tạo mới
            candidate = CandidateMapper.mapToCandidate(new Candidate(), dto);
        }

        Recruitment recruitment = recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found"));
        // Kiểm tra nếu đã ứng tuyển công việc này
        boolean alreadyApplied = candidate.getCandidateRecruitments().stream()
                .anyMatch(cr -> cr.getRecruitment().getId().equals(recruitmentId));

        if (alreadyApplied) {
            throw new IllegalStateException("Bạn đã ứng tuyển công việc này rồi.");
        }
        // Gắn candidate vào recruitment
        CandidateRecruitment cr = CandidateRecruitment.builder()
                .candidate(candidate)
                .recruitment(recruitment)
                .status(CandidateStatus.APPLIED)
                .submittedAt(LocalDateTime.now())
                .build();

        candidate.getCandidateRecruitments().add(cr);

        // Lưu cả ứng viên và bản ghi liên kết
        candidateRepository.save(candidate);
    }

    public List<CandidateResponseDTO> getCandidatesByRecruitmentId(Long recruitmentId) {
        List<CandidateRecruitment> crList = candidateRecruitmentRepository.findByRecruitmentId(recruitmentId);
        return crList.stream()
                .map(CandidateMapper::toCandidateResponseDTO)
                .toList();
    }


    public void saveCandidate(CandidateDto candidateDto) {
        Candidate candidate = CandidateMapper.mapToCandidate(new Candidate(), candidateDto);
        candidateRepository.save(candidate);
    }

}
