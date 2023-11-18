package damanhealth.insuranceMS.service.impl;

import damanhealth.insuranceMS.entity.Benefit;
import damanhealth.insuranceMS.repository.BenefitRepository;
import damanhealth.insuranceMS.service.BenefitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitServiceImpl implements BenefitService {

    private BenefitRepository benefitRepository;

    public BenefitServiceImpl(BenefitRepository benefitRepository) {
        super();
        this.benefitRepository = benefitRepository;
    }

    @Override
    public List<Benefit> getAllBenefits() {
        return benefitRepository.findAll();
    }

    @Override
    public Benefit saveBenefit(Benefit benefit) {
        return benefitRepository.save(benefit);
    }

    @Override
    public Benefit getBenefitById(int id) {
        return benefitRepository.findById(id).get();
    }

    @Override
    public Benefit updateBenefit(Benefit benefit) {
        return benefitRepository.save(benefit);
    }

    @Override
    public void deleteBenefitById(int id) {
        benefitRepository.deleteById(id);
    }
}
