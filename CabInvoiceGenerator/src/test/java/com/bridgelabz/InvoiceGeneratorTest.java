package com.bridgelabz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

	InvoiceGenerator invoiceGenerator;
	
	@Before
	public void init() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 1.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(20, fare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_WhenTotalFareLessThan5_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnRideSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdShouldReturnTheInvoice() {
		String userId = "abc";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
		assertEquals(summary, checkSummary);
	}
}