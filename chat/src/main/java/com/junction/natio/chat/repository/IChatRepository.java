package com.junction.natio.chat.repository;


import com.junction.natio.chat.model.ChatMessageEntity;
import com.junction.natio.core.repository.ICrudRepository;

import java.util.List;

public interface IChatRepository extends ICrudRepository<ChatMessageEntity, Long> {

    List<ChatMessageEntity> getMessagesByChannel(String channel);
}
