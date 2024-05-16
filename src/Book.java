/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kali
 */
public class Book {
    private int bookid, number;
    private String title, author;
    public Book() {
    }

    public Book(int bookid, String title, String author,int number) {
        this.bookid = bookid;
        this.number = number;
        this.title = title;
        this.author = author;
    }
    
    public int getBookid(){
        return this.bookid;
    }
    public String getTitle() {
        return title;
    }
    public int getNumber() {
        return number;
    }
    public String getAuthor() {
        return author;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
