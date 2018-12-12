package com.util;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by anson on 17/11/4.
 */
public class DateEditor extends PropertyEditorSupport {
    //private final DateFormat dateFormat;
    private final boolean allowEmpty;
    private final int exactDateLength;
    private final DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    private final DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DateEditor(boolean allowEmpty) {
        //this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = -1;
    }

    public DateEditor(boolean allowEmpty, int exactDateLength) {
        //this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = exactDateLength;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        if(this.allowEmpty && !StringUtils.hasText(text)) {
            this.setValue((Object)null);
        } else {
            if(text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
                throw new IllegalArgumentException("Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
            }

            try {
                this.setValue(this.dateFormat2.parse(text));
            } catch (ParseException var3) {
                try {
                    this.setValue(this.dateFormat1.parse(text));
                }catch(ParseException var4){
                    throw new IllegalArgumentException("Could not parse date: " + var3.getMessage(), var4);
                }
            }
        }

    }

    public String getAsText() {
        Date value = (Date)this.getValue();
        return value != null?this.dateFormat2.format(value):"";
    }
}
