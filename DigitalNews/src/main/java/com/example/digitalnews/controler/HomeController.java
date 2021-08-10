package com.example.digitalnews.controler;


import com.example.digitalnews.dao.DigitalDAO;
import com.example.digitalnews.entity.DigitalNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

//import java.awt.print.Pageable;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private DigitalDAO digitalDAO;

    @GetMapping("/Home")
    public String displayDigital(Model model){
        List<DigitalNews> list = digitalDAO.getNews(6);
        model.addAttribute("d",list.remove(0));
        model.addAttribute("list",list);
        return "Home";
    }

    @GetMapping("/Detail")
    public String displayDetail(@RequestParam int id,Model model){
        List<DigitalNews> list = digitalDAO.getNews(6);
        DigitalNews digitalNews = digitalDAO.getDigitalNewsById(id);

        model.addAttribute("digitalNews",digitalNews);
        model.addAttribute("d",list.remove(0));
        model.addAttribute("list",list);
        return "Detail";
    }

    @GetMapping("/Search")
    public String displaySearch(@RequestParam String search, Model model,@RequestParam(required = false,defaultValue = "0") int pageIndex){
        List<DigitalNews> list = digitalDAO.getNews(6);

        Pageable pageable = (Pageable) PageRequest.of(pageIndex,3);
        List<DigitalNews> listSearch = digitalDAO.getNewsBySearch(search.trim(),pageable);
        int tottalPage =digitalDAO.count(search)/3;
        if(digitalDAO.count(search)%3>0){
            tottalPage++;
        }
        List<Integer> listInt = new ArrayList<>();
        for(int i=0 ; i < tottalPage ; i++){
            listInt.add(i);
        }


        model.addAttribute("pageIndex",pageIndex);
        model.addAttribute("listInt",listInt);
        model.addAttribute("d",list.remove(0));
        model.addAttribute("list",list);
        model.addAttribute("listSearch",listSearch);
        model.addAttribute("search",search);
        return "Search";
    }

}
