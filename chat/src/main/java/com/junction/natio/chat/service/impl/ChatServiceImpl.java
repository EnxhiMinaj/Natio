package com.junction.natio.chat.service.impl;

import com.junction.natio.chat.model.ChatMessageEntity;
import com.junction.natio.chat.repository.IChatRepository;
import com.junction.natio.chat.service.IChatService;
import com.junction.natio.core.service.impl.CrudServiceImpl;
import com.junction.natio.core.utils.DateUtils;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl extends CrudServiceImpl<ChatMessageEntity, Long> implements IChatService {

    private IChatRepository chatRepository;

    public ChatServiceImpl(IChatRepository chatRepository) {
        super(chatRepository);
        this.chatRepository = chatRepository;
    }


    @Override
    public List<ChatMessageEntity> getMessagesByChannel(String channel) {
        return this.chatRepository.getMessagesByChannel(channel);
    }
}
