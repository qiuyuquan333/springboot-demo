package com.qyq.jpa.dao;

import com.qyq.jpa.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Object> {
}
