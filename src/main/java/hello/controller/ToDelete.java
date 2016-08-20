package hello.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ToDelete {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.parse("20160723"));

    }
}
