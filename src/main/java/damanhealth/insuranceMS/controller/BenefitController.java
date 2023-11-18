package damanhealth.insuranceMS.controller;


import damanhealth.insuranceMS.entity.Benefit;
import damanhealth.insuranceMS.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BenefitController {

    @Autowired
    private BenefitService benefitService;


    public BenefitController(BenefitService benefitService) {
        super();
        this.benefitService = benefitService;
    }


    @GetMapping("/benefits")
    public String listBenefits(Model model) {
        model.addAttribute("benefits", benefitService.getAllBenefits());
        return "benefits";
    }

    @GetMapping("/benefits/new")
    public String createBenefitForm(Model model) {
        Benefit benefit = new Benefit();
        model.addAttribute("benefit", benefit);
        return "create_benefit";
    }

    @PostMapping("/benefits")
    public String saveBenefit(@ModelAttribute("benefit") Benefit benefit) {
        benefitService.saveBenefit(benefit);
        return "redirect:/benefits";
    }
    @GetMapping("/benefits/edit/{id}")
    public String editBenefitForm(@PathVariable int id, Model model) {
        model.addAttribute("benefit", benefitService.getBenefitById(id));
        return "edit_benefit";
    }

    @PostMapping("/benefits/{id}")
    public String updateBenefit(@PathVariable int id, @ModelAttribute("benefit") Benefit benefit, Model model) {
        Benefit existingBenefit = benefitService.getBenefitById(id);
        existingBenefit.setId(id);
        existingBenefit.setName(benefit.getName());
        existingBenefit.setDescription(benefit.getDescription());
        existingBenefit.setCopay(benefit.isCopay());
        benefitService.updateBenefit(existingBenefit);
        return "redirect:/benefits";

    }

    @GetMapping("/benefits/{id}")
    public String deleteBenefit(@PathVariable int id) {
        benefitService.deleteBenefitById(id);
        return "redirect:/benefits";
    }



}
