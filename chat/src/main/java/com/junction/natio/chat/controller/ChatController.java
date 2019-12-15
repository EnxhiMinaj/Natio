package com.junction.natio.chat.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.junction.natio.chat.model.ChatMessageEntity;
import com.junction.natio.chat.requestDto.ChatMessageDto;
import com.junction.natio.chat.service.IChatService;
import com.junction.natio.core.exception.NatioException;
import com.junction.natio.core.model.ResponseObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/natio/chat")
@CrossOrigin("*")
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private IChatService chatService;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate, IChatService chatService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.chatService = chatService;
    }

    @MessageMapping("/send/order")
    public void onReceiveMessage(String chatMessaeDto) {
        System.out.println("message = " + chatMessaeDto);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();

        try {

            // convert JSON string to Map
            map = mapper.readValue(chatMessaeDto, Map.class);

            // it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.simpMessagingTemplate.convertAndSend("/order/"+map.get("channel"), chatMessaeDto);
    }

    @PostMapping("create")
    public ResponseEntity<ResponseObj> changePassword(@RequestBody @Valid ChatMessageDto chatMessageDto) {
        ChatMessageEntity chatMessageEntity = new ChatMessageEntity();
        chatMessageEntity.setEmail(chatMessageDto.getEmail());
        chatMessageEntity.setChannel(chatMessageDto.getChannel());
        chatMessageEntity.setUsername(chatMessageDto.getUsername());
        chatMessageEntity.setSentTime(chatMessageDto.getSentTime());
        chatMessageEntity.setMessage(chatMessageDto.getMessage());
        chatService.save(chatMessageEntity);
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().message("chat message created.").build(), HttpStatus.OK);
    }

    @GetMapping("/channel/{channelName}")
    public ResponseEntity<ResponseObj> getAllNatureLocations(@PathVariable String channelName) {
        List<ChatMessageEntity> entities = chatService.getMessagesByChannel(channelName);
        if (entities.size() == 0) {
            throw new NatioException("Sorry!! No Records Found");
        }
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(entities).message("Success").build(), HttpStatus.OK);
    }
}
