package com.bytechnology.rest.restlearning.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path= "/hello-world")
    public String hello(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning",null,locale);
    }

    @GetMapping(path= {"/hello-bean-world/{name}","/hello-bean-world"})
    public HelloWorldBean helloWorld(@PathVariable(required = false) String name){
        HelloWorldBean helloWorldBean = new HelloWorldBean();
        helloWorldBean.setName(name);
        if(name==null)
            helloWorldBean.setName("ION");
        return helloWorldBean;
    }

    @PostMapping(path= "/hello-bean-world")
    public ResponseEntity<HelloWorldBean> putHelloWorld(@RequestBody HelloWorldBean helloWorldBean){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{name}").buildAndExpand(helloWorldBean.getName()).toUri();

        return ResponseEntity.created(location).body(helloWorldBean);
    }
}
