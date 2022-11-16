package dev.post.bookDraftingCenter.repo;

import dev.post.bookDraftingCenter.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
    Optional<List<Books>> findBooksByGenre(String genre);
    Optional<Books> findByTitle(String title);
    Optional<List<Books>> findByAuthor(String author);
    Optional<Books> findById(int id);
}
