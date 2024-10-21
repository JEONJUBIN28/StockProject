package org.seongsu.stockproject.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.seongsu.stockproject.VO.infomarketVO;



@Mapper
public interface MarketMapper {

	List<infomarketVO> findMarketList(@Param("area_code") int area_code,
			@Param("mrk_open_type") int mrk_open_type, @Param("market_name") String market_name);
	List<infomarketVO> findMarketInfo(@Param("market_code") String market_code);
}

