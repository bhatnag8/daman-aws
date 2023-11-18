package damanhealth.insuranceMS;

import damanhealth.insuranceMS.entity.Benefit;
import damanhealth.insuranceMS.entity.Plan;
import damanhealth.insuranceMS.repository.BenefitRepository;
import damanhealth.insuranceMS.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
public class InsuranceManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceManagementSystemApplication.class, args);
    }

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private BenefitRepository benefitRepository;


    @Override
    public void run(String... args) throws Exception {

        /*
        Plan plan1 = new Plan("Platinum", "AED 33,400,233", "No", "Yes", "Yes");
        planRepository.save(plan1);

        Plan plan2 = new Plan("Platinum Plus", "AED 50,000,000", "Yes", "Yes", "Yes");
        planRepository.save(plan2);

        Plan plan3 = new Plan("Platinum Pro", "AED 70,000,000", "Yes", "Yes", "Yes");
        planRepository.save(plan3);

         */

        //benefitRepository.save(new Benefit("No Benefit"));
    }
}
