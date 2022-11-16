package dev.post.bookDraftingCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharcterDto {

    private int age;
    private String name;
    private String gear;
    private String physicalDescriptions;
    private String backStory;
    private String characterType;
    private int bookId;
}
