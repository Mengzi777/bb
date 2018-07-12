/*
 * DuplexPrinter.cpp
 */
package edu.northeastern.cs_5004;

/**
 * This class implements a DuplexPrinter
 *
 *  @since Jan 20, 2018
 *  @author philip gust
 */
public class DuplexPrinter extends Printer {
	/** Model name */
	static private String modelName = "DuplexPrinter";

	private boolean duplexMode = false;

	/**
	 * Create a new printer.
	 */
	public DuplexPrinter() {
		System.err.printf("DuplexPrinter: constructor called\n");
	}

	/**
	 * Returns the printer model.
	 *
	 * @return the printer model
	 */
	public String model() {
		return DuplexPrinter.modelName;
	}

	/**
	 * Determines whether printer is in duplex mode.
	 * In this mode, pages are printed on front and back.
	 *
	 * @return true if printer is in duplex mode.
	 */
	public boolean duplex()  {
		return duplexMode;
	}

	/**
	 * Determines whether printer is in duplex mode.
	 * In this mode, pages are printed on front and back.
	 *
	 * @return true if printer is in duplex mode.
	 */
	public void duplex(boolean duplexMode) {
		this.duplexMode = duplexMode;
	}


	/**
	 * Printers the specified number of pages.
	 *
	 * @param nPages the number of pages to print
	 * @return the number of pages actually printed
	 */
	public int print(int nPages) {
		// cannot print if offline
		if (offline()) {
			System.err.printf("printer offline\n");
			return 0;
		}

		// cannot print if not ready
		if (!ready()) {
			System.err.printf("printer not ready\n");
			return 0;
		}

		int pagesPerSheet = (duplexMode) ? 2 : 1;
		int pagesPrinted = Math.min(nPages, nSheets*pagesPerSheet);
		System.out.printf("DuplexPrinter printed %d pages\n", pagesPrinted);
		nSheets -= Math.ceil(pagesPrinted/(double)pagesPerSheet);
		return pagesPrinted;
	}
}
