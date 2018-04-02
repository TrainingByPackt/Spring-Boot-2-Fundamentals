package com.packt.springboot.restintro;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;
import static java.time.format.TextStyle.SHORT;

@RestController
public class DateTimeController {

    @Value
    private class DateTime {
        private String date;
        private String time;
        private String zone;
        private String zoneId;
        private String zoneOffset;
    }

    @GetMapping("/api/datetime")
    public DateTime datetime() {
        ZonedDateTime now = ZonedDateTime.now();
        String date = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String time = now.format(DateTimeFormatter.ISO_LOCAL_TIME);
        ZoneId zone = now.getZone();
        ZoneOffset offset = zone.getRules().getOffset(now.toLocalDateTime());
        String zoneString = String.format("%s (%s)",
                zone.getDisplayName(FULL, Locale.UK), zone.getDisplayName(SHORT, Locale.UK));

        return new DateTime(date, time, zoneString, zone.getId(), offset.getId());
    }
}
