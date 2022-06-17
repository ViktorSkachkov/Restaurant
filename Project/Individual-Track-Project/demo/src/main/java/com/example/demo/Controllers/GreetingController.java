package com.example.demo.Controllers;

import com.example.demo.Controllers.model.Greeting;
import com.example.demo.Controllers.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        Greeting returnGreeting = null;
        returnGreeting = new Greeting("Hello, " + message.getName() + "! Welcome to the website of Red Hot Pizza! We hope you like what we have to offer!");
        return returnGreeting;
        //return "Hello " + message.getName();
    }

}