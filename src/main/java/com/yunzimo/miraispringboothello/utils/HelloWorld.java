package com.yunzimo.miraispringboothello.utils;


import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.Face;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    @Value("${bot.master}")
    private String masterQQ;

    //发给bot会回复你的信息
    public void afterLogin(Bot bot) {
        String yourQQNumber = masterQQ;
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event) -> {
            if (yourQQNumber.equals(String.valueOf(event.getSender().getId()))) {
                event.getSubject().sendMessage(new MessageChainBuilder()
                        .append(new QuoteReply(event.getMessage()))
                        .append("Hi, you just said: '")
                        .append(event.getMessage())
                        .append("'")
                        .append(new Face(Face.BAI_TUO))
                        .build()
                );
            }
        });
    }
}
