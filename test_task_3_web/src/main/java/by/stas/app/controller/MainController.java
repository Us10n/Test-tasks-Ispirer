package by.stas.app.controller;

import by.stas.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
@RequestMapping("/main")
public class MainController {

    private final ApplicationService applicationService;

    @Autowired
    public MainController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public String changeLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "post Hello";
    }

    @GetMapping
    public String changeStringGet(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return applicationService.readString();
    }
}
