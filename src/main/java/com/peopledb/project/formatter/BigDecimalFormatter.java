package com.peopledb.project.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class BigDecimalFormatter implements Formatter<BigDecimal>{

    @Override
    public String print(BigDecimal object, Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(object);
    }

    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        return null;
    }
}
