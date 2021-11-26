package com.yunzimo.miraispringboothello.event;

import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.BotOfflineEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.StrangerMessageEvent;
import net.mamoe.mirai.message.data.Message;


/**
 * 基础消息侦听器
 *
 * @author yunzimo
 * @date 2021/11/26
 */
public class BaseMessageListener extends SimpleListenerHost {
    /**
     * Instantiates a new Base message listener.
     */
    public BaseMessageListener() {
        super();
    }

    /**
     * Instantiates a new Base message listener.
     *
     * @param coroutineContext the coroutine context
     */
    public BaseMessageListener(CoroutineContext coroutineContext) {
        super(coroutineContext);
    }

    @Override
    public void handleException(CoroutineContext context, Throwable exception) {
        super.handleException(context, exception);
    }

    /**
     * Hand group message.
     *
     * @param event the event
     */
    @EventHandler
    public void handGroupMessage(GroupMessageEvent event) {
        long q = event.getSender().getId();
        Contact contact = event.getSubject();
        Message message = event.getMessage();
    }

    /**
     * Hand friend message.
     *
     * @param event the event
     */
    @EventHandler
    public void handFriendMessage(FriendMessageEvent event) {
        event.getFriend().sendMessage("你好呀");
    }


    /**
     * 处理陌生人消息
     *
     * @param event 事件
     */
    @EventHandler
    public void handStrangerMessage(StrangerMessageEvent event) {

    }


    /**
     * bot登出
     *
     * @param event 事件
     */
    @EventHandler
    public void onLost(BotOfflineEvent event) {
    }
}
