package az.code.course26a.util;

import java.util.Collection;

public class CollectionUtil {

    public static boolean isNull(Collection collection){
       return collection==null || collection.isEmpty();
    }
    public static boolean nonNull(Collection collection){
       return collection!=null && !collection.isEmpty();
    }


}
