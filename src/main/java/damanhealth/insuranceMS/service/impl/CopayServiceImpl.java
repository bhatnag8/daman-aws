package damanhealth.insuranceMS.service.impl;

import damanhealth.insuranceMS.entity.Copay;
import damanhealth.insuranceMS.repository.CopayRepository;
import damanhealth.insuranceMS.service.CopayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopayServiceImpl implements CopayService {

    private CopayRepository copayRepository;

    public CopayServiceImpl(CopayRepository copayRepository) {
        super();
        this.copayRepository = copayRepository;
    }

    @Override
    public List<Copay> getAllCopays() {
        return copayRepository.findAll();
    }

    @Override
    public Copay saveCopay(Copay copay) {
        return copayRepository.save(copay);
    }

    @Override
    public Copay getCopayById(int id) {
        return copayRepository.findById(id).get();
    }

    @Override
    public Copay updateCopay(Copay copay) {
        return copayRepository.save(copay);
    }

    @Override
    public void deleteCopayById(int id) {
        copayRepository.deleteById(id);

    }
}
