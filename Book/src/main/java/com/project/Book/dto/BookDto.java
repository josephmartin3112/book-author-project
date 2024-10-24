package com.project.Book.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @NotBlank(message = "Book name is required")
    private String name; // book name

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be at least 0")
    private double price; // price of the book

    @NotBlank(message = "Author name is required")
    private String author; // author name

    @NotNull(message = "Published year is required")
    private int publishedYear; // published year
}
