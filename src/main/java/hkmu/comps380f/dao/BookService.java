package hkmu.comps380f.dao;

import hkmu.comps380f.model.Book;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepo;
    @Transactional
    public long createBook(MultipartFile image) throws IOException {
        Book book = new Book();
        book.setFilename(image.getOriginalFilename());
        book.setMimeContentType(image.getContentType());
        book.setContents(image.getBytes());
        Book savedBook = bookRepo.save(book);
        return savedBook.getId();
    }

    @Transactional
    public Book getBook(long id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book " + id + " not found.");
        }
        return book;
    }
}
