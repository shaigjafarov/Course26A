package az.code.course26a.enums;

public enum LanguageEnum {
    AZ("az"),EN("en"),RU("ru");

    String lang;


    LanguageEnum(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
