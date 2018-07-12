/*
 * Printer.cpp
 *
 *  @since Jan 20, 2018
 *  @author philip gust
 */

#include <cstdio>
#include <algorithm>
#include "Printer.h"

namespace CS_5004 {

/** Sheet capacity */
static const unsigned int maxSheets = 500;

/** Model name */
static const string modelName = "Printer";

/**
 * Create a new printer.
 */
Printer::Printer() {
	fprintf(stderr, "Printer: constructor called\n");
}

/**
 * Delete the printer
 */
Printer::~Printer() {
	fprintf(stderr, "Printer destructor called\n");
}

/**
 * Returns the printer model.
 *
 * @return the printer model
 */
const string &Printer::model() const {
	return modelName;
}
/**
 * Determines whether the printer is ready.
 * @return true if the printer is ready
 */
bool Printer::ready() const {
	return nSheets > 0 && !offlineStatus;
}

/**
 * Determines whether the printer is offline.
 *
 * @return true if the printer is offline
 */
bool Printer::offline() const {
	return offlineStatus;
}

/**
 * Sets the offline status of the printer.
 *
 * @param offlineStatus the offline status
 */
void Printer::offline(bool offlineStatus) {
	this->offlineStatus = offlineStatus;
}

/**
 * Returns the sheet capacity of the printer.
 *
 * @return the sheet capacity of the printer
 */
unsigned int Printer::sheetCapacity() const {
	return maxSheets;
}

/**
 * Returns the number of sheets available.
 * @return the nuber of seets available
 */
unsigned int Printer::sheetsAvailable() const {
	return nSheets;
}

/**
 * Add the nummber of sheets to the printer.
 *
 * @param nSheets the number of sheets to add
 * @return the actual number of sheets added
 */
unsigned int Printer::addSheets(unsigned int nSheets) {
	if (nSheets + this->nSheets <= sheetCapacity()){
		// room to add all the sheets
		this->nSheets += nSheets;
		return nSheets;
	} else {
		// only add
		this->nSheets = sheetCapacity();
		return sheetCapacity() - this->nSheets;
	}
}

/**
 * Printers the specified number of pages.
 *
 * @param nPages the number of pages to print
 * @return the number of pages actually printed
 */
unsigned int Printer::print(unsigned int nPages) {
	// cannot print if offline
	if (offline()) {
		fprintf(stderr, "Printer offline\n");
		return 0;
	}

	// cannot print if not ready
	if (!ready()) {
		fprintf(stderr, "Printer not ready\n");
		return 0;
	}

	unsigned int pagesPrinted = std::min(nPages, nSheets);
	fprintf(stdout, "Printer printed %d pages\n", pagesPrinted);
	nSheets -= pagesPrinted;
	return pagesPrinted;
}

} /* namespace CS_5004 */
