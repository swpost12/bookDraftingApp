package dev.post.bookDraftingCenter.services;

import dev.post.bookDraftingCenter.exceptions.BookNotFound;
import org.modelmapper.ModelMapper;
import dev.post.bookDraftingCenter.dto.BookDto;
import dev.post.bookDraftingCenter.models.Books;
import dev.post.bookDraftingCenter.repo.BooksRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BooksRepo br;
    final private Logger logger= LoggerFactory.getLogger(BookService.class);
    private ModelMapper map=new ModelMapper();



    public List<Books> getAll(){
        return br.findAll();
    }

    public List<Books> getAll(String genre, String author){
       if(!genre.isEmpty()){
           return br.findBooksByGenre(genre).orElseThrow();
       }
       return br.findByAuthor(author).orElseThrow();
    }

    public Books getByTitle(String title){
        return br.findByTitle(title).orElseThrow();
    }


    public Books addBook(BookDto newBook){
        Books book=map.map(newBook,Books.class);
        return br.save(book);
    }

    public Books updateBook(BookDto updateInfo, int id) throws BookNotFound {
        Optional<Books> book=br.findById(id);
        if(book.isPresent()){
            Books foundBook=book.get();
            foundBook.setAuthor(updateInfo.getAuthor());
            foundBook.setGenre(updateInfo.getGenre());
            foundBook.setPlot(updateInfo.getPlot());
            foundBook.setTitle(updateInfo.getTitle());
            foundBook.setPageCount(updateInfo.getPageCount());

            logger.info("updated the book with id "+id);
            return br.save(foundBook);
        }
        throw new BookNotFound("book dose not exits");
    }



}
