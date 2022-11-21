package dev.post.bookDraftingCenter.controllers;

import dev.post.bookDraftingCenter.dto.CharcterDto;
import dev.post.bookDraftingCenter.models.Characters;
import dev.post.bookDraftingCenter.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterService cs;


    @GetMapping
    List<Characters> findAll(){
        return cs.findAll();
    }

    @GetMapping("/{id}")
    Characters findById(@PathVariable("id") int id){
        return cs.findById(id);

    }
    @GetMapping("/name")
    Characters findbyName(@RequestParam("name") String name){
        return cs.getByName(name);
    }

    @PostMapping
    Characters addCharacter(@RequestBody CharcterDto dto){
        return cs.add(dto);

    }

    @PutMapping("/{id}")
    Characters updateCharacter(@RequestBody CharcterDto dto, @PathVariable("id") int id){
        return cs.update(dto, id);
    }

}
