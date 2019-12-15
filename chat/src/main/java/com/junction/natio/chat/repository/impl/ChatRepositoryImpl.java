package com.junction.natio.chat.repository.impl;


import com.junction.natio.chat.model.ChatMessageEntity;
import com.junction.natio.chat.model.QChatMessageEntity;
import com.junction.natio.chat.repository.IChatRepository;
import com.junction.natio.core.repository.impl.CrudRepositoryImpl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatRepositoryImpl extends CrudRepositoryImpl<ChatMessageEntity, Long> implements IChatRepository {
    public ChatRepositoryImpl() {
        super(ChatMessageEntity.class);
    }


    @Override
    public List<ChatMessageEntity> getMessagesByChannel(String channel) {
        QChatMessageEntity qChatMessageEntity = QChatMessageEntity.chatMessageEntity;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        List<ChatMessageEntity> results = jpaQueryFactory
                .selectFrom(qChatMessageEntity)
                .where(qChatMessageEntity.channel.eq(channel))
                .fetch();
        return results;
    }
}
