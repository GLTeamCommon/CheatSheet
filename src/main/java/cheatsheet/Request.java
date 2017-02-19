package cheatsheet;

import java.lang.StringBuilder;

public class Request {

    private String content;

    public String getAnswer() {
        return new StringBuilder(this.content).reverse().toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}