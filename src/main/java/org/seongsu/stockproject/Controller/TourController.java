package org.seongsu.stockproject.Controller;

import java.util.List;

import org.seongsu.stockproject.Service.TourService;
import org.seongsu.stockproject.VO.infotourVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/tour")
public class TourController {

    @Autowired
    private TourService tourService;

    // 게시물 목록
    @GetMapping("/list")
    public String list(Model model) {
        List<infotourVO> tourList = tourService.getTourList();
        model.addAttribute("tourList", tourList);
        return "tour/list"; 
    }

    // 게시물 상세
    @GetMapping("/detail")
    public String getTourDetail(@RequestParam("tour_code") String tourCode, Model model) {
    	infotourVO tour = tourService.getTourDetail(tourCode);
        model.addAttribute("tour", tour);
        return "tour/detail"; 
    }
    
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<infotourVO> searchResults = tourService.searchTour(keyword);
        model.addAttribute("tourList", searchResults);
        return "tour/list"; // 검색 결과를 리스트 페이지에 반환
    }

    // 게시물 수정 화면
    @GetMapping("/edit")
    public String editTourForm(@RequestParam("tour_code") String tourCode, Model model) {
    	infotourVO tour = tourService.getTourDetail(tourCode);
        model.addAttribute("tour", tour);
        return "tour/edit"; // edit.jsp로 이동
    }

    // 게시물 수정 처리
    @PostMapping("/update")
    public String updateTour(@ModelAttribute infotourVO tour) {
        tourService.updateTour(tour);
        return "redirect:/tour/list"; // 수정 후 목록으로 리다이렉트
    }

    // 게시물 추가 폼
    @GetMapping("/create")
    public String createTourForm(Model model) {
        model.addAttribute("tour", new infotourVO());
        return "tour/create"; 
    }

    // 게시물 추가 처리
    @PostMapping("/create")
    public String createTour(@ModelAttribute infotourVO tour) {
        tourService.createTour(tour);
        return "redirect:/tour/list"; 
    }

    // 게시물 삭제
    @PostMapping("/delete")
    public String deleteTour(@RequestParam("tour_code") String tourCode) {
        tourService.deleteTour(tourCode);
        return "redirect:/tour/list"; 
    }
}
