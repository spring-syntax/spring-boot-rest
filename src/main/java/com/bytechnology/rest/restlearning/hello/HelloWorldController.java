package com.bytechnology.rest.restlearning.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class HelloWorldController {

    @GetMapping(path= "/hello-world")
    public String hello(){
        return "Hello World";
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
