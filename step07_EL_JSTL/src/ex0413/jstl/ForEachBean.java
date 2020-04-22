package ex0413.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String[] names= {"선호", "민호", "희윤", "효정", "진혁", "영진"};
	private List<String> menus = Arrays.asList(new String[] {"짜장", "짬뽕", "짬짜면", "탕수육", "팔보채", "울면"});
	private List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	
	private Map<String, String> map = new HashMap<>();
	
	public ForEachBean() {
		memberList.add(new MemberDTO("jang", 20, "판교", "111-1111"));
		memberList.add(new MemberDTO("kim", 23, "대구", "222-2222"));
		memberList.add(new MemberDTO("king", 21, "부산", "333-3333"));
		memberList.add(new MemberDTO("girl", 23, "제주도", "444-4444"));
		memberList.add(new MemberDTO("queen", 25, "서울", "555-5555"));
		
		map.put("kr", "대한민국");
		map.put("jp", "일본");
		map.put("cn", "중국");
		map.put("us", "미국");
		map.put("fr", "프랑스");
	}

	public String[] getNames() {
		return names;
	}

	public List<String> getMenus() {
		return menus;
	}

	public List<MemberDTO> getMemberList() {
		return memberList;
	}

	public Map<String, String> getMap() {
		return map;
	}
	
	
}
