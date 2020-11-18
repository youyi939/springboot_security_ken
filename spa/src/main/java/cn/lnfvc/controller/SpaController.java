package cn.lnfvc.controller;

import cn.lnfvc.entitis.Book;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: KenChen
 * @date 2020/11/16 4:49 下午
 */

@Controller
public class SpaController {

    static List<Book> bookList = new ArrayList<>();
    static {
        for (int i = 0 ; i <10;i ++){
            Book book = new Book(i,"第一行代码Andoird 第三版");
          bookList.add(book);
        }
    }

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }


    @CrossOrigin
    @GetMapping(value = "/books")
    @ResponseBody
    public List<Book> findAllBook(){
        return bookList;
    }

    @ResponseBody
    @DeleteMapping(value = "/delete/{id}")
    public Book delete(@PathVariable("id") Integer id){
        int index = -1;
        for (int i = 0; i < bookList.size();i++){
            if (id == bookList.get(i).getId()){
                index = i;
                break;
            }
        }
        bookList.remove(index);
        Book book = new Book();
        book.setId(id);
        return book;
    }







}