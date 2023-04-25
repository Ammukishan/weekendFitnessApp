package com.uh.wfc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WFCTestCases {
	

	@Test
	public void bookSessionTest() {
		System.out.println("validating book a session method");
		List<String> testData = new ArrayList<>();
		List<String> ttbleTestData = new ArrayList<>();
		List<List<String>> testDta = new  ArrayList<>();
		BookingInfo bi = new BookingInfo();
		TimeTable tt = new TimeTable();
		ttbleTestData = tt.fitnessSchedule();
		testData = bi.custDeatils();
		GroupSession grpSession = new GroupSession();
		testDta = grpSession.bookASession(ttbleTestData, testData, "cust09");
		assertNotNull(testDta);
	}
	
	@Test
	public void cancelSessionTest() {
		System.out.println("validating cancel a session method");
		List<String> testData = new ArrayList<>();
		List<String> ttbleTestData = new ArrayList<>();
		List<List<String>> testDta = new  ArrayList<>();
		BookingInfo bi = new BookingInfo();
		Modify modf = new Modify();
		TimeTable tt = new TimeTable();
		ttbleTestData = tt.fitnessSchedule();
		testData = bi.custDeatils();
		modf.cancelBooking(ttbleTestData, testData);
		assertNotNull(testDta);
	}
	
	@Test
	public void modifySessionTest() {
		System.out.println("validating Modify book a session method");
		List<String> testData = new ArrayList<>();
		List<String> ttbleTestData = new ArrayList<>();
		List<List<String>> testDta = new  ArrayList<>();
		BookingInfo bi = new BookingInfo();
		Modify modf = new Modify();
		TimeTable tt = new TimeTable();
		ttbleTestData = tt.fitnessSchedule();
		testData = bi.custDeatils();
		modf.changeBooking(ttbleTestData, testData);		
		assertNotNull(testDta);
	}
	
	@Test
	public void attendSessionTest() {
		System.out.println("validating attend a session method");
		List<String> testData = new ArrayList<>();
		BookingInfo bi = new BookingInfo();
		testData = bi.custDeatils();
		Attend att = new Attend();
		att.attendASession(testData);
		
	}
	
	//validate month report
	@Test
	public void monthReportTest() {
		System.out.println("validating monthly report");
		List<String> testData = new ArrayList<>();
		BookingInfo bi = new BookingInfo();
		testData = bi.custDeatils();
		MonthlyReport mr = new  MonthlyReport();
		mr.monthLessonReport(testData,3);
		
	}

	//validate month report
	@Test
	public void monthChampReportTest() {
		System.out.println("validating monthly champion report");
		List<String> testData = new ArrayList<>();
		BookingInfo bi = new BookingInfo();
		testData = bi.custDeatils();
		MonthlyChampionReport mr = new  MonthlyChampionReport();
		mr.monthChampionReport(testData,4);
	}

}
