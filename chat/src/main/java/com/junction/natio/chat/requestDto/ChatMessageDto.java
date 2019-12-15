package com.junction.natio.chat.requestDto;

import com.junction.natio.core.model.ModelBase;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChatMessageDto extends ModelBase {
   private String email;
   private String channel;
   private String message;
   private String username;
   private String sentTime;
}
