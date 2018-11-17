package com.cp.chisana.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Chandra.Sarathe on 11/17/2018.
 */
@RestController
@RequestMapping("/api/")
public class URLShortnerController {

    @GetMapping(value = "keys")
    @ResponseBody
    public String getKeys() {
        return "hi chisana service";
    }

}
