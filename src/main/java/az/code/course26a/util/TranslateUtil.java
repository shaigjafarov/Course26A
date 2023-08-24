package az.code.course26a.util;

import az.code.course26a.enums.LanguageEnum;

import java.util.Map;

public class TranslateUtil {

    static Map<String, String>  stringMap= Map.of("student_not_found_en","student not found: ",
                                           "student_not_found_az", "telebe tapilamadi: ",
            "student_not_found_ru", "rusca telebe tapilmadi: ");


     public static String translate(LanguageEnum lang, String key ){
         String mapKey=key+"_"+lang.getLang();

         String value= stringMap.get(mapKey);
        return value;
     }

}
