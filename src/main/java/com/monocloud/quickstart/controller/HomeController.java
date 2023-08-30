package com.monocloud.quickstart.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(OAuth2AuthenticationToken authentication) {
        var profileDetails = new HashMap<String, Object>();
        if (authentication != null)
        {
            profileDetails.put("isAuthenticated", true);
            profileDetails.put("details", authentication.getPrincipal().getAttributes());
        } else {
            profileDetails.put("isAuthenticated", false);
        }
        return new ModelAndView("index" , profileDetails);
    }

}

