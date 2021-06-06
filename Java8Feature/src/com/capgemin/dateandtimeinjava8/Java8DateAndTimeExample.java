package com.capgemin.dateandtimeinjava8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Java8DateAndTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		//time
		LocalTime lTime = LocalTime.of(12, 20);
		System.out.println(lTime);
		//date and time
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		//time zone
		OffsetDateTime odt = OffsetDateTime.now();
		System.out.println(odt);
		//Zone date and time
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(zdt);
		Instant instant = Instant.now();
		System.out.println(instant);
		Instant instant1 = instant.plus(Duration.ofMillis(5000));
		System.out.println(instant1);
	
		Duration dur = Duration.ofMillis(5000);
		System.out.println(dur);
		Period p1 = Period.between(localDate.now(), localDate.now().plusDays(368));
		System.out.println(p1);
		
		Period p = Period.of(8, 5, 25);
		System.out.println(p.getDays());
		System.out.println(p.getMonths());
		System.out.println(p.getYears());
		
		LocalDate date1  = LocalDate.now();
		LocalDate date2  = LocalDate.now().plusDays(50);
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		System.out.println(daysBetween);
		
		
		
		
		
		
		
		
		
		
	
	}

}
