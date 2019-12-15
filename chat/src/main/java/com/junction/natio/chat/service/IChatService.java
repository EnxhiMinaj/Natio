package com.junction.natio.chat.service;


import com.junction.natio.chat.model.ChatMessageEntity;
import com.junction.natio.core.service.ICrudService;


import java.util.List;

/**

 */
public interface IChatService extends ICrudService<ChatMessageEntity, Long> {

    List<ChatMessageEntity> getMessagesByChannel(String channel);

}
