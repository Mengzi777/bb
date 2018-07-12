/*
 * PrinterTest.java
 */
package edu.northeastern.cs_5004;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;  
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runners.MethodSorters;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

/**
 * This class implements unit tests for Printer and DuplexPrinter.
 *
 *  @since Jan 20, 2018
 *  @author philip gust
 */
public class PrinterTest {
	/**
	 * Test Printer.
	 */
	@Test
	public void testPrinter() {
		System.err.printf("\n");
		Printer printer = new Printer();

		// report the model;
		String printerModel = printer.model();
		assertEquals("Printer", printerModel);

		// report offline status
		boolean offline = printer.offline();
		assertTrue(offline);

		// report ready status
		boolean ready = printer.ready();
		assertFalse(ready);

		// report sheets available (no paper)
		int nSheets = printer.sheetsAvailable();
		assertEquals(nSheets, 0);

		// print when printer is offline and not ready
		int nPages = printer.print(3);
		assertEquals(nPages, 0);

		// put printer online
		printer.offline(false);

		// print when printer is online but not ready
		nPages = printer.print(3);
		assertEquals(nPages, 0);

		// add sheets to printer
		int capacity = printer.sheetCapacity();
		assertEquals(capacity, 500);
		int added = printer.addSheets(capacity);
		assertEquals(capacity, added);
		added = printer.addSheets(10);
		assertEquals(added, 0);
		ready = printer.ready();
		assertTrue(ready);

		// print when printer is online and ready
		nPages = printer.print(3);
		assertEquals(3, nPages);
		nSheets = printer.sheetsAvailable();
		assertEquals(capacity-nPages,nSheets);

		// print more than available page capacity
		nPages = printer.print(capacity);
		assertEquals(nPages, nSheets);
		nSheets = printer.sheetsAvailable();
		assertEquals(0, nSheets);

		// out of paper: not ready
		ready = printer.ready();
		assertFalse(ready);
	}

	/**
	 * Test the DuplexPrinter subclass of Printer
	 */
	@Test
	public void testDuplexPrinter() {
		System.err.printf("\n");
		DuplexPrinter printer = new DuplexPrinter();

		// report the model;
		String printerModel = printer.model();
		assertEquals(printerModel, "DuplexPrinter");

		// report duplex mode
		boolean duplex = printer.duplex();
		assertFalse(duplex);

		// report offline status
		boolean offline = printer.offline();
		assertTrue(offline);

		// report ready status
		boolean ready = printer.ready();
		assertFalse(ready);

		// report sheets available (no paper)
		int nSheets = printer.sheetsAvailable();
		assertEquals(nSheets, 0);

		// print when printer is offline and not ready
		int nPages = printer.print(3);
		assertEquals(nPages, 0);

		// put printer online
		printer.offline(false);

		// print when printer is online but not ready
		nPages = printer.print(3);
		assertEquals(nPages, 0);

		// add sheets to printer
		int capacity = printer.sheetCapacity();
		assertEquals(500, capacity);
		int added = printer.addSheets(capacity);
		assertEquals(added, capacity);
		added = printer.addSheets(10);
		assertEquals(added, 0);
		ready = printer.ready();
		assertTrue(ready);


		// print non-duplex when printer is online and ready
		nPages = printer.print(3);
		assertEquals(nPages, 3);
		nSheets = printer.sheetsAvailable();
		assertEquals(nSheets, capacity-nPages);

		// set printer to duplex mode
		printer.duplex(true);
		duplex = printer.duplex();
		assertTrue(duplex);

		// print more than available page capacity
		nPages = printer.print(capacity*2);  // prints on both sides
		assertEquals(nPages, nSheets*2);  // prints on both sides
		nSheets = printer.sheetsAvailable();
		assertEquals(nSheets, 0);

		// out of paper: not ready
		ready = printer.ready();
		assertFalse(ready);
	}


	/**
	 * Test Printer reference to a DuplexPrinter.
	 */
	@Test
	public void testDuplexPrinterRef() {
		System.err.printf("\n");
		DuplexPrinter duplexPrinter = new DuplexPrinter();
		Printer printer = duplexPrinter;  // alias as regular printer

		// get duplex printer name through duplexPrinter ref
		String duplexPrinterModel = duplexPrinter.model();   // model as duplex printer
		assertEquals(duplexPrinterModel, "DuplexPrinter");

		// get duplex printer name through printer ref
		String printerModel = printer.model();  // model as regular printer
		assertEquals(printerModel, "DuplexPrinter");
	}

	/**
	 * Run the tests in this class.
	 * 
	 * @param args the program arguments
	 */
	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(PrinterTest.class);
	    
	    System.out.println("[Unit Test Results]");
	    System.out.println();
	    
	    if (result.getFailureCount() > 0) {
	    	System.out.println("Test failure details:");
		    for (Failure failure : result.getFailures()) {
		       System.out.println(failure.toString());
		    }
		    System.out.println();
	    }
	    
	    int passCount = result.getRunCount()-result.getFailureCount()-result.getIgnoreCount(); 
	    System.out.println("Test summary:");
	    System.out.println("* Total tests = " + result.getRunCount());
	    System.out.println("* Passed tests: " + passCount);
	    System.out.println("* Failed tests = " + result.getFailureCount());
	    System.out.println("* Inactive tests = " + result.getIgnoreCount());
	}
}
