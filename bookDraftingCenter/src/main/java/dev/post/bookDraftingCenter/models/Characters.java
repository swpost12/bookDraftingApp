package dev.post.bookDraftingCenter.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gear;
    @Column(nullable = false)
    private String physicalDescriptions;
    @Column(nullable = false)
    private String backStory;
    @Column(nullable = false)
    private String characterType;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Books bookId;
}
