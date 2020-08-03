package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static Map<Character, Character> mapCharVietLower = new HashMap<>();

    static {
        String strViet 			    = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ";
        String strVietLowerKoDau 	= "aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyaaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzaaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyaaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyy";
        for (int i = 0; i < strViet.length(); i++) {
            if (!mapCharVietLower.containsKey(strViet.charAt(i)))
                mapCharVietLower.put(strViet.charAt(i), strVietLowerKoDau.charAt(i));
        }
//        List<Character> arrChar = new ArrayList<>();
//        arrChar.add(new Character((char) 768));
//        arrChar.add(new Character((char) 769));
//        arrChar.add(new Character((char) 771));
//        arrChar.add(new Character((char) 777));
//        arrChar.add(new Character((char) 803));
//        for (Character c: arrChar){
//            mapCharVietLower.put(c,null);
//        }
    }
    public static void main(String[] args) {

        String s1 = "365 hoàng cầu";
        String s2 ="công ty VMG, 36 Hoàng Cầu, Đống Đa, Hà Nội";

        System.out.println(calulator(s1,s2));
    }
    static float calulator(String str1, String str2) {
        //tinh toan ket qua cuoi cung
        if(str1.isEmpty()||str2.isEmpty()){
            return (float) 0;
        }
        String stringLowerNoAccent1=toLowerAndNoAccent(str1);
        String[] arrWord1=splitWord(stringLowerNoAccent1);

        Map<String, Integer> map1=arrayToMap(arrWord1);
        int t1= arrWord1.length;

        String stringLowerNoAccent2=toLowerAndNoAccent(str2);
        String[] arrWord2=splitWord(stringLowerNoAccent2);
        Map<String, Integer> map2=arrayToMap(arrWord2);
        int t2= arrWord2.length;
        if(arrWord1.length==0 || arrWord2.length==0) {
            return (float) 0;
        }
        int n1= checkin(map2,arrWord1);
        System.out.println("tu so 1 co so tu nam trong tu so 2 n1=" +n1+"---t1="+t1);
        int n2= checkin(map1,arrWord2);
        System.out.println("tu so 2 co so tu nam trong tu so 1 n2=" +n2+"---t1="+t2);
        float S=((float)n1/t1 + (float)n2/t2)/2;
        return S;
    }
    static int checkin(Map<String,Integer> map,String[] arr) {
        //map la nhung phan tu khac nhau trong string can so sanh
        //arr la string muon so sanh
        int result=0;
        for (String str : arr) {
            if(map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            }
        }
        for (int i : map.values()) {
            if(i>0) {
                result+=i;
            }
        }
        return result;
    }
    static String[] splitWord(String input) {
        //tach chuoi dua tren khoang trang khoang trang co the la 1 hoac n
        String[] words = input.trim().split("\\s+");
        //cat khoang trang 2 dau va cac khoang nhieu hon 1 (s+)

        return words;
    }

    static Map<String,Integer> arrayToMap(String[] arrString){
        //convert array to hashMap
        //Chuyen array to hash map loai bo nhung phan tu trung lap de doi chieu
        Map<String, Integer> result=new HashMap<String,Integer>();
        for (String str : arrString) {
            result.put(str, 0);
        }
        return result;
    }

    public static String toLowerAndNoAccent(String str) {
        //chuyen ki tu ve chu thuong va khong dau
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (mapCharVietLower.containsKey(str.charAt(i))) {
                if (mapCharVietLower.get(str.charAt(i))!=null)
                    sb.append(mapCharVietLower.get(str.charAt(i)));
            }
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}