package com.mycorp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZendeskController {

	@RequestMapping("/")
    public String serverRunning() {
		return "Spring boot running...";
	}
}
