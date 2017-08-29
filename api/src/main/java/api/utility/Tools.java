package api.utility;

import java.sql.Timestamp;

/**
 * Created by khengny on 8/20/17.
 */
public class Tools {

    public static int DEF_PER_PAGE = 10;
    public static int DEF_PAGE = 0;
    public static Byte DEF_STATUS = 1;

    public static Timestamp getCurrentDate(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static boolean isNull(Object value){
        if(value == null){
            return true;
        }
        return false;
    }

    public static Object checkNull(Object value, Object elseValue){
        if(value == null){
            return elseValue;
        }
        return value;
    }

    public static int toInt(Object num){
        return Integer.parseInt(num.toString());
    }

    public static byte toByte(Object a){
        return Byte.parseByte(a.toString());
    }

}
