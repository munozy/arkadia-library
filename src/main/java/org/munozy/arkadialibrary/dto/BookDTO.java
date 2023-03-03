package org.munozy.arkadialibrary.dto;

import org.munozy.arkadialibrary.domain.Book;

public record BookDTO(String id, String title, String author, String collection, Integer volume) {

    public static BookDTO create(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getCollection(), book.getVolume());
    }
}
