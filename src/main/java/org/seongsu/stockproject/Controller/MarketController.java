package org.seongsu.stockproject.Controller;

import java.util.List;

import org.seongsu.stockproject.Service.MarketService;
import org.seongsu.stockproject.VO.infomarketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/market")
public class MarketController {

	@Autowired
	private MarketService marketService;

	@GetMapping("/marketlist")
	public List<infomarketVO> getMarketList(
			@RequestParam(required = false) int area_code,
			@RequestParam(required = false) int mrk_open_type, 
			@RequestParam(required = false) String market_name) {
		
		log.info(">>>> getMarketList() ..");
		System.out.println(">>>>> MarketController >>> getMarketList() .. area_code: " + area_code + " - " + mrk_open_type + " - " +  market_name);
		return marketService.findMarketList(area_code, mrk_open_type, market_name);
	}

	@PostMapping("/marketinfo/{market_code}")
	public ModelAndView getMarketInfo(infomarketVO infomarketVO) {
		
		log.info(">>>> MarketController >> getMarketInfo2() ..");
		System.out.println(">>>>> MarketController >>> getMarketInfo2() .. market_code: " + infomarketVO.getMarket_code() );
		ModelAndView mv = new ModelAndView();
		
		
		List<infomarketVO> market =  marketService.findMarketInfo(infomarketVO.getMarket_code());

		mv.addObject("markets", market);
		

		//System.out.println(">MMMMMMMM>>>> MarketController >>> getMarketInfo2() .. List<MarketListVO> market: " + market );
		//System.out.println(">MMMMMMMM>>>> MarketController >>> getMarketInfo2() .. market_code: " + marketListVO.getMarket_code() );
		//System.out.println(">MMMMMMMM>>>> MarketController >>> getMarketInfo2() .. market_name: " + marketListVO.getMarket_name() );
		
		mv.setViewName("market/market_info");
		return mv;

	}
	
	@PostMapping("/content_view23/{market_code}")
    public String getMarketInfo3(@RequestParam("market_code") String market_code, Model model) {
		log.info(">>>> MarketController >> getMarketInfo3() ..");
		System.out.println(">>>>> MarketController >>> getMarketInfo3() .. market_code: " + market_code);
		
		List<infomarketVO> market = marketService.findMarketInfo(market_code);
		
        model.addAttribute("market", market);
        return "market/content_view2"; 
    }
	
	
}
