package be.pxl.rest.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class MyJmsListener {

    @JmsListener(destination = "HelloQueue")
    public void onMessage(Message msg) {

        if (msg instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) msg).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
