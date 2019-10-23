package com.ghifar.teksAnalyzer.controller;

import com.ghifar.teksAnalyzer.model.TeksAnlysis;
import com.ghifar.teksAnalyzer.service.TeksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    TeksService teksService;

    @GetMapping("/analyze")
    public String analyze(@RequestParam (name="text") String text, Model model){

        if(text.length() >  255){
            model.addAttribute("error", true);
            model.addAttribute("error_msg", "Cant be more than 255 Chars");
            return "errorPage";
        }

        ArrayList<Character> hurufList = teksService.getHurufs(text);
        ArrayList<TeksAnlysis> analysis = teksService.getAnalyzedText(hurufList, text);

        model.addAttribute("analysis" ,analysis);
        model.addAttribute("text", text);
        model.addAttribute("error", false);

        return "teksPage";
    }

}
