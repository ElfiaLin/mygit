package com.jxd.emp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.emp.model.Book;

import java.util.List;

public interface IBookService extends IService<Book> {
    List<Book> selectBookWithPublic();
}
