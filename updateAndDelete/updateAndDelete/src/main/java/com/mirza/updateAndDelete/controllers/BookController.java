package com.mirza.updateAndDelete.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirza.updateAndDelete.model.Book;
import com.mirza.updateAndDelete.services.BookService;


@Controller
public class BookController {
 private final BookService bookService;
 
 public BookController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("/books")
 public String index(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "books/index.jsp";
 }
 
 @RequestMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 @RequestMapping(value="/books", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 @RequestMapping("/books/{id}")
 public String show(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "/books/show.jsp";
 }
 @RequestMapping("/books/{id}/edit")
 public String edit(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "/books/edit.jsp";
 }
 
 @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
 public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/edit.jsp";
     } else {
         bookService.updateBook(id, book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
         return "redirect:/books";
     }
 }
 
 @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
 public String destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
     return "redirect:/books";
 }

}