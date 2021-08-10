package com.example.digitalnews.dao;

import com.example.digitalnews.entity.DigitalNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

//import java.awt.print.Pageable;
import java.util.List;

public interface DigitalDAO extends JpaRepository<DigitalNews,Integer> {
    @Query(value = "SELECT * FROM DigitalNews Order by date LIMIT ?1",nativeQuery = true)
    public List<DigitalNews> getNews(int top);

    @Query(value = "SELECT * FROM DigitalNews WHERE title LIKE %?1%",nativeQuery = true)
    public List<DigitalNews> getNewsBySearch(String search , Pageable pageable);

    @Query("SELECT count (d) FROM DigitalNews d WHERE d.title LIKE %?1%")
    public int count(String search);


    public DigitalNews getDigitalNewsById(int id);


}
