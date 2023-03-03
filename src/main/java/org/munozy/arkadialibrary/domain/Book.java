package org.munozy.arkadialibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String author;

    private String collection;

    private Integer volume;

}
