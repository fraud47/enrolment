package zw.apkmechanik.enrolment.utils;

import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class RegistrationUtils {
    private static final int UNIQUE_NUMBER_RANGE = 100000;
    public String getRegistrationNumber(String institute){
        Year currentYear = Year.now();
        int uniqueNumber = ThreadLocalRandom.current().nextInt(UNIQUE_NUMBER_RANGE);
        return institute.charAt(0) + currentYear.toString() + String.format("%02d", uniqueNumber);
    }
}
