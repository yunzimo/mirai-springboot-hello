package com.yunzimo.miraispringboothello;

import com.yunzimo.miraispringboothello.utils.HelloWorld;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.Face;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MiraiSpringbootHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiraiSpringbootHelloApplication.class, args);
    }
}
