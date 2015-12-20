package service;

import model.Message;

/**
 * Created by vlad on 20.12.15.
 */
public class MessageService {

    private Message message =  new Message("Hello! I'm multi-module web application!");

    public String getMessage() {
        return message.getText();
    }

}
