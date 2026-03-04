package sep490.com.example.hrms_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sep490.com.example.hrms_backend.HrmsBackendApplication;
import sep490.com.example.hrms_backend.dto.PositionDTO;
import sep490.com.example.hrms_backend.dto.benefit.BenefitResponse;
import sep490.com.example.hrms_backend.entity.Position;
import sep490.com.example.hrms_backend.exception.HRMSAPIException;
import sep490.com.example.hrms_backend.repository.BenefitPositionRepository;
import sep490.com.example.hrms_backend.repository.PositionRepository;
import sep490.com.example.hrms_backend.service.PositionService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final BenefitPositionRepository benefitPositionRepository;

    private final ModelMapper modelMapper;


    //tested
    @Override
    public List<PositionDTO> getPositionsNotRegisteredToBenefit(Long benefitId) {
        // 1. Lấy danh sách ID position đã đăng ký benefit này
        List<Long> registeredPositionIds = benefitPositionRepository.findPositionIdsByBenefitId(benefitId);

        // 2. Lấy tất cả position KHÔNG thuộc danh sách trên
        List<Position> availablePositions ;
        // 2. Nếu chưa gán cho position nào thì trả về toàn bộ danh sách
        if (registeredPositionIds == null || registeredPositionIds.isEmpty()) {
            availablePositions = positionRepository.findAll();
        } else {
            availablePositions = positionRepository.findByPositionIdNotIn(registeredPositionIds);
        }
        // 3. Convert sang DTO
        List<PositionDTO> positionDTOList = availablePositions.stream()
                .map(position -> modelMapper.map(position, PositionDTO.class)).toList();

        return positionDTOList;

    }
    //tested
    @Override
    public PositionDTO getPositionById(Long positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new HRMSAPIException("Vị trí với id " + positionId + " không tồn tại."));

        return modelMapper.map(position, PositionDTO.class) ;
    }


}
