package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tinhToan {

	public static void main(String[] args) {
		
		
			List<HashMap<String, Object>> list = new ArrayList<> ();
			
			HashMap<String, Object> map1 = new HashMap<> ();
			map1.put("id",63);
			map1.put("username", "testttt");
			map1.put("firstName", "Trịnh");

			HashMap<String, Object> map2 = new HashMap<> ();
	        map2.put("id",65);
			map2.put("username", "leroy.wilderman");
			map2.put("firstName", "hoang");
			
			list.add(map1);
			list.add(map2);
			
			
			for (HashMap<String, Object> item : list) {
				Integer id = (Integer) item.get("id");
				if (id == 63) {
					System.out.println(item);
				}
			}
			
//			for (int i = 0; i < list.size(); i++) {
//				
//				Integer k = (Integer) list.get(i).get("id");
//				if (k == 65) {
//					System.out.println(list.get(i));
//				}
//			}
	   

	}
}
