package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
	 

	public static void main(String[] args) {
		
        String s1 = "36 hoàng cầu";
        String s2 ="công ty VMG, 36 Hoàng Cầu, Đống Đa, Hà Nội";
		
    	Map<Character, Character>  mapCharTiengViet = new HashMap<>();
    	String strTiengViet = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ";
    	String strTiengVietKoDau = "aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyaaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzaaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyaaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyy";
    	
    	for(int i = 0; i < strTiengViet.length(); i++) {
    		if(!mapCharTiengViet.containsKey(strTiengViet.charAt(i))) {
    			mapCharTiengViet.put(strTiengViet.charAt(i), strTiengVietKoDau.charAt(i));
    		}
    	}
    	
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (mapCharTiengViet.containsKey(s1.charAt(i))) {
                if (mapCharTiengViet.get(s1.charAt(i))!=null)
                    sb1.append(mapCharTiengViet.get(s1.charAt(i)));
            }
            else
                sb1.append(s1.charAt(i));
        }
        String s1LowerAndUnsigned = sb1.toString();
        
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if (mapCharTiengViet.containsKey(s2.charAt(i))) {
                if (mapCharTiengViet.get(s2.charAt(i))!=null)
                    sb2.append(mapCharTiengViet.get(s2.charAt(i)));
            }
            else
                sb2.append(s2.charAt(i));
        }
        String s2LowerAndUnsigned = sb2.toString();
        
        String[] arrWord1 = s1LowerAndUnsigned.trim().split("\\s+");
        String[] arrWord2 = s2LowerAndUnsigned.trim().split("\\s+");

        if(arrWord1.length==0 || arrWord2.length==0) {
        	System.out.println("S= 0");
        } else {
        	int t1= arrWord1.length;
        	int n1 = count(arrWord1, arrWord2);
        	int t2= arrWord2.length;
        	int n2 = count(arrWord2, arrWord1);
        	float S=((float)n1/t1 + (float)n2/t2)/2;
        	System.out.println("tu so 1 co so tu nam trong tu so 2 n1=" +n1+"---t1="+t1);
        	System.out.println("tu so 2 co so tu nam trong tu so 1 n2=" +n2+"---t1="+t2);
        	System.out.println("S= " +S);
        }
	}
	
	
	static int count(String[] str1, String[] str2) {	
		int kq = 0;
		
		List<String> list2 = new ArrayList<String>();
		
		for(String item: str2) {
			list2.add(item);
		}
		
		for(String item: str1) {
			if(list2.contains(item)) {
				kq ++;
			}
		}
		
		return kq;
	}

}
