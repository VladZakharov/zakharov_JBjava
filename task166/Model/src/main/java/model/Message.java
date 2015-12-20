package model;

/**
 * Created by vlad on 20.12.15.
 */
public class Message {

    private String text;

    public Message(String text) {
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
