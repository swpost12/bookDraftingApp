package dev.post.bookDraftingCenter.repo;

import dev.post.bookDraftingCenter.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CharacterRepo extends JpaRepository<Characters,Integer> {
    public Optional<Characters> findByName(String name);

    public Optional<List<Characters>> findByBookId(int id);


}
