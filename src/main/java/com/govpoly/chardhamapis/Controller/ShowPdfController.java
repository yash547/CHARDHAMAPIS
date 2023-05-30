package com.govpoly.chardhamapis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowPdfController {

    @RequestMapping("/showhelpproject")
    public String displauPdf() {
        return "projectpdf";
    }

}
