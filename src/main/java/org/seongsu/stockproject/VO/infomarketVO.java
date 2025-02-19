package org.seongsu.stockproject.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class infomarketVO {
	private String market_code;
	private String market_name;
	private int market_type;
	private String market_address;
	private int area_code;
	private int mrk_open_type;
	private int open_1;
	private int open_2;
	private String ark_yn;
	private String elb_yn;
	private String cus_yn;
	private String spr_yn;
	private String fire_yn;
	private String child_yn;
	private String call_yn;
	private String hyu_yn;
	private String mo_yn;
	private String mulpum_yn;
	private String cycle_yn;
	private String play_yn;
	private String book_yn;
	private String cart_yn;
	private String frgn_yn;
	private String road_yn;
	private String broad_yn;
	private String culture_yn;
	private String cargo_yn;
	private String parking_yn;
	private String edu_yn;
	private String meeting_yn;
	private String heart_yn;
	private String toilet_yn;
	private float wido;
	private float gyungdo;
	private int shop_cnt;
	private String homepage;
	private int open_year;
	private String tel_no;
	// 아래는 조인
	private String area_name;
	private String open_type_name;
	private String mrk_open_date;
}
