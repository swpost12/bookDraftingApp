package dev.post.bookDraftingCenter.exceptions;

public class BookNotFound extends RuntimeException{
    public BookNotFound(String msg){
        super(msg);
    }
}
