package dev.post.bookDraftingCenter.exceptions;

public class MaxCharactersException extends RuntimeException {
    public MaxCharactersException(String msg){
        super(msg);
    }
}
