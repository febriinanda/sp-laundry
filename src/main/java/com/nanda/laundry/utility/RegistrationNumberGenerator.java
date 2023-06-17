package com.nanda.laundry.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RegistrationNumberGenerator {
    public static String generate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        Random random = new Random();
        int rnd = random.nextInt(999999);

        return String.format("%04d", year) + '.' + String.format("%02d", month) + '.' + String.format("%06d", rnd);
    }
}
