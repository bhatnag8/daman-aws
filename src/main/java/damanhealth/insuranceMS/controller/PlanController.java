package damanhealth.insuranceMS.controller;

import damanhealth.insuranceMS.entity.Plan;
import damanhealth.insuranceMS.service.BenefitService;
import damanhealth.insuranceMS.service.CopayService;
import damanhealth.insuranceMS.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private BenefitService benefitService;

    @Autowired
    private CopayService copayService;

    public PlanController(PlanService planService, BenefitService benefitService) {
        super();
        this.planService = planService;
        this.benefitService = benefitService;
    }

    @GetMapping("/plans")
    public String listPlans(Model model) {
        model.addAttribute("plans", planService.getAllPlans());
        return "plans";
    }


    @GetMapping("/plans/new")
    public String createPlanForm(Model model) {
        Plan plan = new Plan();
        model.addAttribute("plan", plan);
        model.addAttribute("benefits", benefitService.getAllBenefits());
        model.addAttribute("copays", copayService.getAllCopays());
        return "create_plan";
    }

    @PostMapping("/plans")
    public String savePlan(@ModelAttribute("plan") Plan plan) {
        planService.savePlan(plan);
        return "redirect:/plans";
    }
    @GetMapping("/plans/edit/{id}")
    public String editPlanForm(@PathVariable int id, Model model) {
        model.addAttribute("plan", planService.getPlanById(id));
        model.addAttribute("benefits", benefitService.getAllBenefits());
        model.addAttribute("copays", copayService.getAllCopays());
        return "edit_plan";
    }

    @PostMapping("/plans/{id}")
    public String updatePlan(@PathVariable int id, @ModelAttribute("plan") Plan plan, Model model) {
            Plan existingPlan = planService.getPlanById(id);
            existingPlan.setId(id);
            existingPlan.setName(plan.getName());
            existingPlan.setDescription(plan.getDescription());
            existingPlan.setActive(plan.isActive());
            existingPlan.setPremium(plan.getPremium());
            existingPlan.setBenefit(plan.getBenefit());
            planService.updatePlan(existingPlan);
            return "redirect:/plans";
    }

    @GetMapping("/plans/enable/{id}")
    public String enable(@PathVariable int id, @ModelAttribute("plan") Plan plan, Model model) {
        Plan existingPlan = planService.getPlanById(id);
        plan.changeToActive();
        existingPlan.setActive(plan.isActive());
        planService.updatePlan(existingPlan);
        return "redirect:/plans";
    }

    @GetMapping("/plans/disable/{id}")
    public String disable(@PathVariable int id, @ModelAttribute("plan") Plan plan, Model model) {
        Plan existingPlan = planService.getPlanById(id);
        plan.changeToInactive();
        existingPlan.setActive(plan.isActive());
        planService.updatePlan(existingPlan);
        return "redirect:/plans";
    }



    @GetMapping("/plans/{id}")
    public String deletePlan(@PathVariable int id) {
        planService.deletePlanById(id);
        return "redirect:/plans";
    }
}
