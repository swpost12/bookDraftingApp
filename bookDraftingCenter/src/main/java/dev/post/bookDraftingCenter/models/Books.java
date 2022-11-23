package dev.post.bookDraftingCenter.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String plot;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private int pageCount;
    @Column(nullable = false)
    private String genre;

    @OneToMany( mappedBy = "bookId")
    @JsonIgnore
    private List<Characters> charactersList;



}
