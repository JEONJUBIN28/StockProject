package org.seongsu.stockproject.Service;

import java.util.List;

import org.seongsu.stockproject.Mapper.MarketMapper;
import org.seongsu.stockproject.VO.infomarketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MarketService {
	
	@Autowired
    private MarketMapper marketMapper;	
	/**
	 * 특정 조건에 따라 시장 목록을 조회합니다.
	 *
	 * @param area_code 지역 코드
	 * @param mrk_open_type 시장 개방 유형
	 * @param market_name 시장 이름
	 * @return 시장 목록
	 */
	public List<infomarketVO> findMarketList(int area_code, int mrk_open_type, String market_name) {
		System.out.println(">>>>> MarketService >>> findMarketList() .. area_code: " + area_code + " - " + mrk_open_type + " - " +  market_name);
        
		List<infomarketVO> vo = marketMapper.findMarketList(area_code, mrk_open_type,market_name);
		System.out.println(vo);
		return marketMapper.findMarketList(area_code, mrk_open_type,market_name);
	}
	public List<infomarketVO> findMarketInfo(String market_code) {
		System.out.println(">>>>> MarketService >>> findMarketInfo() .. market_code: " + market_code);
        
		List<infomarketVO> vo = marketMapper.findMarketInfo(market_code);
		System.out.println(vo);
		return marketMapper.findMarketInfo(market_code);
	}
	
}
