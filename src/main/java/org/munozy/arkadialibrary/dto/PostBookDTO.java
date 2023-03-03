package org.munozy.arkadialibrary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class PostBookDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private String collection;
    private Integer volume;
}
