package com.yunzimo.miraispringboothello.event;


import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.Face;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 主QQ回复
 *
 * @author yunzimo
 * @date 2021/11/26
 */
@Component
public class MasterReply {

    @Value("${bot.master}")
    private String masterQQ;

    /**
     * bot登录后，会回复主QQ的消息（重复）.
     *
     * @param bot the bot
     */
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
