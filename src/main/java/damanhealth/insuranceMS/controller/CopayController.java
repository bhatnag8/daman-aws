package damanhealth.insuranceMS.controller;



import damanhealth.insuranceMS.entity.Copay;
import damanhealth.insuranceMS.service.CopayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CopayController {

    @Autowired
    private CopayService copayService;


    public CopayController(CopayService copayService) {
        super();
        this.copayService = copayService;
    }


    @GetMapping("/copays")
    public String listCopays(Model model) {
        model.addAttribute("copays", copayService.getAllCopays());
        return "copays";
    }

    @GetMapping("/copays/new")
    public String createCopayForm(Model model) {
        Copay copay = new Copay();
        model.addAttribute("copay", copay);
        return "create_copay";
    }

    @PostMapping("/copays")
    public String saveCopay(@ModelAttribute("copay") Copay copay) {
        copayService.saveCopay(copay);
        return "redirect:/copays";
    }
    @GetMapping("/copays/edit/{id}")
    public String editCopayForm(@PathVariable int id, Model model) {
        model.addAttribute("copay", copayService.getCopayById(id));
        return "edit_copay";
    }

    @PostMapping("/copays/{id}")
    public String updateCopay(@PathVariable int id, @ModelAttribute("copay") Copay copay, Model model) {
        Copay existingCopay = copayService.getCopayById(id);
        existingCopay.setId(id);
        existingCopay.setName(copay.getName());
        existingCopay.setDescription(copay.getDescription());
        copayService.updateCopay(existingCopay);
        return "redirect:/copays";

    }

    @GetMapping("/copays/{id}")
    public String deleteCopay(@PathVariable int id) {
        copayService.deleteCopayById(id);
        return "redirect:/copays";
    }



}
