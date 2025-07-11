package com.library.management;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx =
                 new ClassPathXmlApplicationContext("applicationContext.xml")) {

            BookService service = ctx.getBean(BookService.class);
            service.addBook("Spring in Action");   // invoke any method
        }
    }
}
