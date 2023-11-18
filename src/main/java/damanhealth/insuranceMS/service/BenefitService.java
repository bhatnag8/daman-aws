package damanhealth.insuranceMS.service;

import damanhealth.insuranceMS.entity.Benefit;

import java.util.List;

public interface BenefitService {

    List<Benefit> getAllBenefits();

    Benefit saveBenefit(Benefit benefit);
    Benefit getBenefitById(int id);
    Benefit updateBenefit(Benefit benefit);
    void deleteBenefitById(int id);


}
