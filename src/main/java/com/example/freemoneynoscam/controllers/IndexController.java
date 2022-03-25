package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repository.EmailRepository;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/connection")
    public String connection() {
        return "redirect:/";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        //Getting the parameter from the addEmail-method from the ValidateEmailService-class
        String isEmailValid = ValidateEmailService.addEmail(dataFromForm.getParameter("email"));
        //If isEmailValid equal with successful
        if (isEmailValid.equals("successful")) {
            //Redirect to the successful template
            return "redirect:/successful";
        } else {
            //Else redirect to the unsuccessful template
            return "redirect:/unsuccessful";
        }
    }

    @GetMapping("/unsuccessful")
    public String unsuccessful() {
        return "unsuccessful";
    }

    @GetMapping("/successful")
    public String successful() {
        return "successful";
    }

    @GetMapping("/fetchingSingleEmail")
    public String fetchingSingleEmail(Model model) {
        //Fetching an email from the fetchSingleEmail-method from the EmailRepository
        String email = EmailRepository.fetchSingleEmail();
        //Using model to
        model.addAttribute("fetchingSingleEmail", email);

        return "fetchingSingleEmail";
    }

    @GetMapping("/fetchingAllEmails")
    public String fetchingAllEmails(Model model) {
        List<String> emails = EmailRepository.fetchAllEmails();
        model.addAttribute("fetchingAllEmails", emails);

        return "fetchingAllEmails";
    }

}
