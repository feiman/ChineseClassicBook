package com.d.dao.chineseclassicbook.bean;

/**
 * Created by dao on 2017/2/26.
 */

public class Tang extends BaseBean{
    private String title;
    private String type;
    private String content;
    private String explanation;
    private String appreciation;
    private String author;
    private String translation;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Tang{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", explanation='" + explanation + '\'' +
                ", appreciation='" + appreciation + '\'' +
                ", author='" + author + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
