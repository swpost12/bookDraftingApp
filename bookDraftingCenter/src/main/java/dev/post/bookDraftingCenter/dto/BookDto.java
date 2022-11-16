package dev.post.bookDraftingCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BookDto {
    private String title;

    private String plot;

    private String author;

    private int pageCount;

    private String genre;
}
