package com.tangzhe.controller;

import com.tangzhe.activemq.QueueSender;
import com.tangzhe.activemq.TopicSender;
import com.tangzhe.entity.User;
import com.tangzhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QueueSender queueSender;
    @Autowired
    private TopicSender topicSender;

    @RequestMapping("/test")
    public String test(Model model) {
        User user = userService.findById(1);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/activemq")
    @ResponseBody
    public String activemq() {
        queueSender.send("tangzhe.queue", "老王QUEUE来了");
        topicSender.send("tangzhe.topic", "老王TOPIC来了");
        return "success";
    }

}
