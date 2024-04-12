package hkmu.comps380f.controller;

import hkmu.comps380f.dao.BookService;
import hkmu.comps380f.model.Book;
import hkmu.comps380f.view.DownloadingView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;
    public static class BookForm {

        private MultipartFile image;

        public MultipartFile getImage() {
            return image;
        }

        public void setImage(MultipartFile image) {
            this.image = image;
        }
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("book/add", "bookForm", new BookForm());
    }
    @PostMapping("/create")
    public View create(BookForm form) throws IOException {
        long bookId = bookService.createBook(form.getImage());
        return new RedirectView("/book/view/" + bookId, true);
    }

    @GetMapping("/view/{bookId}")
    public String view(@PathVariable("bookId") long bookId, ModelMap model) {
        Book book = bookService.getBook(bookId);
        model.addAttribute("bookId", bookId);
        model.addAttribute("book", book);
        return "book/view";
    }

    @GetMapping("/image/{bookId}")
    public View download(@PathVariable("bookId") long bookId) {
        Book book = bookService.getBook(bookId);
        return new DownloadingView(book.getFilename(),
                book.getMimeContentType(), book.getContents());
    }
}
