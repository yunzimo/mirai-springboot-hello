package com.yunzimo.miraispringboothello.service;

import com.yunzimo.miraispringboothello.event.MasterReply;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Login {

    @Value("${bot.qq}")
    private  Long qq;

    @Value("${bot.passwdMd5}")
    private  String passwdMd5;

    @Value("${bot.passwd}")
    private String passwd;

    @Autowired
    private MasterReply masterReply;

    @PostConstruct
    public void register() {
        //使用自定义配置登录bot
        Bot bot = BotFactory.INSTANCE.newBot(qq, passwd, new BotConfiguration() {{
            fileBasedDeviceInfo(); // 使用 device.json 存储设备信息
            setProtocol(MiraiProtocol.ANDROID_PAD); // 切换协议
        }});
        bot.login();
        masterReply.afterLogin(bot);
    }
}
