package by.stas.app.controller;

import by.stas.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
public class MainController {

    private final ApplicationService applicationService;

    @Autowired
    public MainController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ModelAndView loadIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/main")
    @ResponseBody
    public String changeStringGet(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        return applicationService.readLabelString();
    }

    @PostMapping("/main")
    @ResponseBody
    public String changeLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        return applicationService.readButtonString();
    }
}
