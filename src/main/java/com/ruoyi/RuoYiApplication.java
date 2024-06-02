package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("============================================\n" +
                "                .  .                        \n" +
                "              \\_|//     LongTau            \n" +
                "  =_       _-~o~  \\/    Health Information \n" +
                "  |\\=_    -_--~/_-~|-   System             \n" +
                "    \\\\-_    '-~7  /-    社区卫生服务中心     \n" +
                "     \\\\ -_    /  /-     信息系统            \n" +
                "       \\\\ ~-_/  /|- _                      \n" +
                "  \\     ~==-/   | \\~-   启动成功            \n" +
                "  -|      /|    |-~\\~                       \n" +
                "============================================\n");
    }
}