package com.example.kmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

@Service
public class UtilService {

    private final DateFormat dateFormatter;
    private DateFormat requestDateFormatter;

    @Autowired
    public UtilService(DateFormat requestDateFormatter, DateFormat dateFormatter) {
        this.requestDateFormatter = requestDateFormatter;
        this.dateFormatter = dateFormatter;
    }

    Date parseDate(String end) throws RuntimeException {
        try {
            Date parse = requestDateFormatter.parse(end);
            String format = dateFormatter.format(parse);
            return dateFormatter.parse(format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    String formatDate(Date date) {
        return dateFormatter.format(date);
    }
}
