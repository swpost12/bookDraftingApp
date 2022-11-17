package dev.post.bookDraftingCenter.advice;

import dev.post.bookDraftingCenter.exceptions.BookNotFound;
import dev.post.bookDraftingCenter.exceptions.CharacterNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {

    Logger log= LoggerFactory.getLogger(NotFoundAdvice.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {BookNotFound.class,
            CharacterNotFound.class})
    public String handler(RuntimeException e){
        log.warn(e.getMessage());
        return e.getMessage();
    }
}
