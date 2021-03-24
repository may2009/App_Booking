package com.example.demo.controller;

import com.example.demo.dao.ChatMessageRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.dao.UserRepository;
import com.example.demo.models.*;
import com.example.demo.services.UserService;
import com.example.demo.services.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")

public class ChatController {

    @Autowired
    private UsersService usersServices;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatMessageRepo chatMessageRepo;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {

        ChatMessage chatMessage1 = new ChatMessage();

        String sender  = chatMessage.getSender();
        String content = chatMessage.getContent();

         chatMessage1.setSender(sender);
         chatMessage1.setContent(content);
         chatMessageRepo.save(chatMessage1);

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }


    @RequestMapping(value="/chat", method= RequestMethod.GET)
    public ModelAndView chat(){

        Map<String, Object> model = new HashMap<String, Object>();
        List<Users> users = userRepository.findAll();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersServices.findUserByUserName(auth.getName());
        List<ChatMessage> chatMessage = chatMessageRepo.findAllOrderBy();

        model.put("users",users);
        model.put("chatMessage",chatMessage);
        model.put("userConnect",user.getUserName());


        return new ModelAndView("/admin/chat",model);
    }


}
