import java.util.HashMap;
public class Methods {

public static boolean Check(String email, String password, HashMap<String, String> list){
       boolean isvalid=false;
       String realPassword=list.get(email);
       if(realPassword.equals(password)) {
           isvalid=true;
       }
return isvalid;
}

    public static String getKey(HashMap<String, Integer> mapref, int value) {
        String key = "";
        for (HashMap.Entry<String, Integer> map : mapref.entrySet()) {
            if (map.getValue().toString().equals(value)) {
                key = map.getKey();
            }
        }
        return key;
    }
}

