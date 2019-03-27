package com.demo.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author haishen
 * @date 2019/3/26
 */
public class Library {

    private String name;

    private Book book;

    @Autowired
    private Desk desk;


    public Library() {
        System.out.println("实例化Library");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void say() {
        System.out.println("图书馆:[" + name + "]桌子上:[" + desk.getName() + "]放了一本:" + book.getName());
    }
}
