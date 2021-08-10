package com.example.digitalnews.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Digitalnews")
public class DigitalNews {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    public DigitalNews(int id, String title, String content, String image, String author, String date, String shortContent) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.date = date;
        this.shortContent = shortContent;
    }

    @Column(name = "shortcontent")
    private String shortContent;


    public DigitalNews() {
    }
}
