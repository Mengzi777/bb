/*
 * Printer.cpp
 */
package edu.northeastern.cs_5004;

/**
 * This class implements a Printer
 * 
 * @author philip gust
 */
public class Printer {
	/** Sheet capacity */
	static private int maxSheets = 500;

	/** Model name */
	static private String modelName = "Printer";

	/** the offline status of the printer */
	private boolean offlineStatus = true;
	

	/** the number of sheets in the printer */
	protected int nSheets = 0;

	/**
	 * Create a new printer.
	 */
	public Printer() {
		System.err.printf("Printer: constructor called\n");
	}

	/**
	 * Returns the printer model.
	 *
	 * @return the printer model
	 */
	public String model() {
		return Printer.modelName;
	}
	/**
	 * Determines whether the printer is ready.
	 * @return true if the printer is ready
	 */
	public boolean ready() {
		return nSheets > 0 && !offlineStatus;
	}

	/**
	 * Determines whether the printer is offline.
	 *
	 * @return true if the printer is offline
	 */
	public boolean offline() {
		return offlineStatus;
	}

	/**
	 * Sets the offline status of the printer.
	 *
	 * @param offlineStatus the offline status
	 */
	public void offline(boolean offlineStatus) {
		this.offlineStatus = offlineStatus;
	}

	/**
	 * Returns the sheet capacity of the printer.
	 *
	 * @return the sheet capacity of the printer
	 */
	public int sheetCapacity() {
		return Printer.maxSheets;
	}

	/**
	 * Returns the number of sheets available.
	 * @return the nuber of seets available
	 */
	public int sheetsAvailable() {
		return nSheets;
	}

	/**
	 * Add the number of sheets to the printer.
	 *
	 * @param nSheets the number of sheets to add
	 * @return the actual number of sheets added
	 */
	public int addSheets(int nSheets) {
		if (nSheets + this.nSheets <= sheetCapacity()){
			// room to add all the sheets
			this.nSheets += nSheets;
			return nSheets;
		} else {
			// only add
			this.nSheets = sheetCapacity();
			return sheetCapacity() - this.nSheets;
		}
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
			System.err.printf("Printer offline\n");
			return 0;
		}

		// cannot print if not ready
		if (!ready()) {
			System.err.printf("Printer not ready\n");
			return 0;
		}

		int pagesPrinted = Math.min(nPages, nSheets);
		System.out.printf("Printer printed %d pages\n", pagesPrinted);
		nSheets -= pagesPrinted;
		return pagesPrinted;
	}
}
