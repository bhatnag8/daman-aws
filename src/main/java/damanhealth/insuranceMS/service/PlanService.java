package damanhealth.insuranceMS.service;

import damanhealth.insuranceMS.entity.Plan;

import java.util.List;

public interface PlanService {

    List<Plan> getAllPlans();

    Plan savePlan(Plan plan);
    Plan getPlanById(int id);
    Plan updatePlan(Plan plan);
    void deletePlanById(int id);
}
