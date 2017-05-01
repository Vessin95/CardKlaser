package com.wojciech.janowski.web.controller;

import com.wojciech.janowski.klaser.Card;
import com.wojciech.janowski.klaser.Status;
import com.wojciech.janowski.klaser.services.KlaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class KlaserController {

    @Autowired
    //@Qualifier("spring")
    private KlaserService klaserService;

    @ModelAttribute("statusAll")
    public List<Status> populateStatus() {
        return Arrays.asList(Status.ALL);
    }

    @ModelAttribute("cardsAll")
    public List<Card> populateCards() {
        return this.klaserService.findAll();
    }

    @ModelAttribute("duplicates")
    public List<Card> duplicates() {
        return this.klaserService.findDuplicates();
    }

    @ModelAttribute("cardsToSell")
    public List<Card> populateCardsToSell() {
        return this.klaserService.findAllToSell();
    }

    @ModelAttribute("cardsLast3")
    public List<Card> populateLast3Cards() {
        return this.klaserService.findLatest3();
    }

    @RequestMapping({ "/", "/index" })
    public String index(ModelMap model) {
        model.put("msg", "Wartosc z modelu");
        return "index";
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public String showMainPage() {
        return "cards";
    }

    @RequestMapping("/tosell")
    public String showToSellPage() {
        return "tosell";
    }

    @RequestMapping("/duplicates")
    public String showDuplicates() {
        return "duplicates";
    }
}
