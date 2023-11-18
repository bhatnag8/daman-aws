package damanhealth.insuranceMS.service;

import damanhealth.insuranceMS.entity.Copay;

import java.util.List;

public interface CopayService {

    List<Copay> getAllCopays();
    Copay saveCopay(Copay copay);
    Copay getCopayById(int id);
    Copay updateCopay(Copay copay);
    void deleteCopayById(int id);


}
