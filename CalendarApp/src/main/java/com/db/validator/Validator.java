package com.db.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Pattern p = Pattern.
            compile("(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4} " +
                    "(1[0-2]|0?[0-9]):[0-5][0-9]:[0-5][0-9] ?([AaPp][Mm])");

    public boolean validateDate(String strDate) {
        Matcher m = p.matcher(strDate);
        return m.matches();
    }
}
