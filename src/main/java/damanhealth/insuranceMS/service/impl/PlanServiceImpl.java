package damanhealth.insuranceMS.service.impl;

import damanhealth.insuranceMS.entity.Plan;
import damanhealth.insuranceMS.repository.PlanRepository;
import damanhealth.insuranceMS.service.PlanService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        super();
        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan getPlanById(int id) {
        return planRepository.findById(id).get();
    }

    @Override
    public Plan updatePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void deletePlanById(int id) {
        planRepository.deleteById(id);
    }
}

