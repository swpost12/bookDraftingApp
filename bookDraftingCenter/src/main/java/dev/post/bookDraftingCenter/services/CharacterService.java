package dev.post.bookDraftingCenter.services;

import dev.post.bookDraftingCenter.dto.CharcterDto;
import dev.post.bookDraftingCenter.exceptions.BookNotFound;
import dev.post.bookDraftingCenter.exceptions.CharacterNotFound;
import dev.post.bookDraftingCenter.exceptions.MaxCharactersException;
import dev.post.bookDraftingCenter.models.Books;
import dev.post.bookDraftingCenter.models.Characters;
import dev.post.bookDraftingCenter.repo.BooksRepo;
import dev.post.bookDraftingCenter.repo.CharacterRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterService {
    @Autowired
    private CharacterRepo cr;
    @Autowired
    private BooksRepo br;
    private final Logger log= LoggerFactory.getLogger(CharacterService.class);

    private final ModelMapper map=new ModelMapper();



    public List<Characters> findAll(){
        return cr.findAll();
    }

    public Characters findById(int id){
        return cr.findById(id).orElseThrow(()->{throw new CharacterNotFound("did not find the character");
        });
    }

    public Characters getByName(String name){
        return cr.findByName(name).orElseThrow(()->{throw new CharacterNotFound("did not find the character");
        });

    }

    public Characters add(CharcterDto dto) throws MaxCharactersException {
        List<Characters> charactersList=cr.findByBookId(dto.getBookId()).orElseThrow(()->{
            throw new BookNotFound("did not find book");
        });
        if(!(charactersList.size()<=3)){
            log.warn("max character reached");
            throw new MaxCharactersException("the book already has three characters");
        }


        Characters c=map.map(dto,Characters.class);
        Books book=br.getReferenceById(dto.getBookId());
        c.setBookId(book);
        log.info("added a new character "+c.getName());
        return cr.save(c);

    }

    public Characters update(CharcterDto newCharacter, int id){
        Characters oldCharacter=cr.findById(id).orElseThrow(()->{
            throw new CharacterNotFound("that character dose not exist");
        });

        oldCharacter.setCharacterType(newCharacter.getCharacterType());
        oldCharacter.setAge(newCharacter.getAge());
        oldCharacter.setBackStory((newCharacter.getBackStory()));
        oldCharacter.setGear(newCharacter.getGear());
        oldCharacter.setName(newCharacter.getName());
        oldCharacter.setPhysicalDescriptions(newCharacter.getPhysicalDescriptions());
        oldCharacter.setBookId(br.getReferenceById(newCharacter.getBookId()));
        log.info("updated a new character");
        return cr.save(oldCharacter);

    }





}
