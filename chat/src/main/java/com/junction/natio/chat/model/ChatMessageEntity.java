package com.junction.natio.chat.model;

import com.junction.natio.core.model.EntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "chat")
public class ChatMessageEntity extends EntityBase {
   @Column(name="email")
   private String email;
   @Column(name="username")
   private String username;
   @Column(name="channel")
   private String channel;
   @Column(name="message")
   private String message;
   @Column(name="sentTime")
   private String sentTime;
}
