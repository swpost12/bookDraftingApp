package dev.post.bookDraftingCenter.advice;

import dev.post.bookDraftingCenter.exceptions.MaxCharactersException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CharacterLimitReached {

//    use annotation
//            responsebody
//    exceptiopion handler with the class
//           responseStatsus
//function the has exceptions as parameter and return msg
    private final Logger log= LoggerFactory.getLogger(CharacterLimitReached.class);

    @ResponseBody
    @ExceptionHandler(value=MaxCharactersException.class)
    @ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
    public String handler(MaxCharactersException e){
        log.warn(e.getMessage());
        return e.getMessage();
    }


}
