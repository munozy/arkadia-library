package org.munozy.arkadialibrary.repository;

import org.munozy.arkadialibrary.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository  extends MongoRepository<Book, String> {

}
