package az.code.course26a.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PushNotification {

    @Scheduled(cron = "*/5 * * * * ?")
    void notifyUser(){

        System.out.println(LocalDateTime.now());
    }

}
