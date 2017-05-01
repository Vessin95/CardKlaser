package com.wojciech.janowski.web.controller;

import com.wojciech.janowski.klaser.*;
import com.wojciech.janowski.klaser.services.KlaserService;
import com.wojciech.janowski.klaser.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
public class CardsController {

    @Autowired
    //@Qualifier("spring")
    private KlaserService klaserService;

    @Autowired
    private NotificationService notificationService;

    @ModelAttribute("statusAll")
    public List<Status> populateStatus() {
        return Arrays.asList(Status.ALL);
    }

    @ModelAttribute("cardTypeAll")
    public List<CardType> populateCardType() {
        return Arrays.asList(CardType.ALL);
    }

    @ModelAttribute("monsterTypeAll")
    public List<MonsterType> populateMonsterType() {
        return Arrays.asList(MonsterType.ALL);
    }

    @ModelAttribute("attributeAll")
    public List<Attribute> populateAttribute() {
        return Arrays.asList(Attribute.ALL);
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, final ModelMap model) {
        Optional<Card> result;
        result = klaserService.findByID(id);
        if (result.isPresent()) {
            Card card = result.get();
            model.addAttribute("card", card);
            return "card";
        } else {
            notificationService.addErrorMessage("Cannot find moneta #" + id);
            model.clear();
            return "redirect:/cards";
        }
    }

    @RequestMapping(value = "/cards/{id}/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Card> viewAsJson(@PathVariable("id") Long id, final ModelMap model) {
        Optional<Card> result;
        result = klaserService.findByID(id);
        if (result.isPresent()) {
            Card card = result.get();
            return new ResponseEntity<Card>(card, HttpStatus.OK);
        } else {
            notificationService.addErrorMessage("Cannot find moneta #" + id);
            model.clear();
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/cards", params = { "save" }, method = RequestMethod.POST)
    public String saveCard(Card card, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "card";
        }
        Optional<Card> result = klaserService.edit(card);
        if (result.isPresent())
            notificationService.addInfoMessage("Zapis udany");
        else
            notificationService.addErrorMessage("Zapis NIE udany");
        model.clear();
        return "redirect:/cards";
    }

    @RequestMapping(value = "/cards", params = { "create" }, method = RequestMethod.POST)
    public String createCard(Card card, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "card";
        }
        klaserService.create(card);
        model.clear();
        notificationService.addInfoMessage("Zapis nowej udany");
        return "redirect:/cards";
    }

    @RequestMapping(value = "/cards/create", method = RequestMethod.GET)
    public String showMainPages(final Card card) {
        card.setPurchaseDate(Calendar.getInstance().getTime());
        return "card";
    }

    @RequestMapping(value = "/cards", params = { "remove" }, method = RequestMethod.POST)
    public String removeRow(final Card card, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("remove"));
        Optional<Boolean> result = klaserService.deleteByID(rowId.longValue());
        return "redirect:/cards";
    }

    @RequestMapping(value = "/cards", params = { "edit" }, method = RequestMethod.GET)
    public String editRow(Card card, final BindingResult bindingResult, final HttpServletRequest req) {
        final Long rowId = Long.valueOf(req.getParameter("edit"));
        Optional<Card> result = klaserService.edit(card);
        if (result.isPresent()) {
            Card c = result.get();
            return "redirect:/cards/" + c.getCatalogNumber();
        } else {
            return "cards";
        }
    }
}
