package dev.post.bookDraftingCenter.controllers;

import dev.post.bookDraftingCenter.dto.BookDto;
import dev.post.bookDraftingCenter.exceptions.BookNotFound;
import dev.post.bookDraftingCenter.models.Books;
import dev.post.bookDraftingCenter.services.BookService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    ModelMapper mapper=new ModelMapper();
    final private Logger logger= LoggerFactory.getLogger(BookController.class);

    @GetMapping
    @ResponseBody
    public List<Books> getAllBooks(@RequestParam(required = false) String author, @RequestParam(required = false) String genre){
        try{
            if(!(author==null) || !(genre==null)) {
                return bookService.getAll(genre, author);
            }

            return bookService.getAll();
        } catch (Exception e){
            logger.warn(e.getMessage());
            return null;

        }
    }

    @GetMapping("/title")
    @ResponseBody
    Books getBookByTitle(@RequestParam String title) {
        try {
            return bookService.getByTitle(title);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return null;
        }
    }
    @PostMapping
    @ResponseBody
    public Books addBook(@RequestBody BookDto dto){
        return bookService.addBook(dto);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public Books updateBook(@RequestBody BookDto dto, @PathVariable("id") int id){
        try {
            return bookService.updateBook(dto,id);
        } catch (BookNotFound e) {
            logger.warn(e.getMessage());
            throw new RuntimeException(e);
        }
    }





}