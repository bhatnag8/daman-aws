package damanhealth.insuranceMS.controller;

import damanhealth.insuranceMS.entity.Plan;
import damanhealth.insuranceMS.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanControllerPostman {

    @Autowired
    private PlanService planService;

    @RequestMapping("/insuranceplans")
    public List<Plan> getAllPlans() {

        return planService.getAllPlans();
    }

    @RequestMapping("/insuranceplans/{id}")
    public Plan getPlan(@PathVariable int id) {
        return planService.getPlanById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/insuranceplans")
    public void addPlan(@RequestBody Plan plan) {
        planService.savePlan(plan);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/insuranceplans/{id}")
    public void updatePlan(@RequestBody Plan plan, @PathVariable int id) {
        planService.updatePlan(plan);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/insuranceplans/{id}")
    public void deletePlan(@PathVariable int id) {
        planService.deletePlanById(id);
    }
}
