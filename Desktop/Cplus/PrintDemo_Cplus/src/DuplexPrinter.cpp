/*
 * DuplexPrinter.cpp
 *
 *  @since Jan 20, 2018
 *  @author philip gust
 */

#include <cmath>
#include "DuplexPrinter.h"

namespace CS_5004 {

/** Model name */
static const string modelName = "DuplexPrinter";

/**
 * Create a new printer.
 */
DuplexPrinter::DuplexPrinter() {
	fprintf(stderr, "DuplexPrinter: constructor called\n");
}

/**
 * Delete the printer.
 */
DuplexPrinter::~DuplexPrinter() {
	fprintf(stderr, "DuplexPrinter: destructor called\n");
}

/**
 * Returns the printer model.
 *
 * @return the printer model
 */
const string &DuplexPrinter::model() const {
	return modelName;
}

/**
 * Determines whether printer is in duplex mode.
 * In this mode, pages are printed on front and back.
 *
 * @return true if printer is in duplex mode.
 */
bool DuplexPrinter::duplex() const {
	return duplexMode;
}

/**
 * Determines whether printer is in duplex mode.
 * In this mode, pages are printed on front and back.
 *
 * @return true if printer is in duplex mode.
 */
void DuplexPrinter::duplex(bool duplexMode) {
	this->duplexMode = duplexMode;
}


/**
 * Printers the specified number of pages.
 *
 * @param nPages the number of pages to print
 * @return the number of pages actually printed
 */
unsigned int DuplexPrinter::print(unsigned int nPages) {
	// cannot print if offline
	if (offline()) {
		fprintf(stderr, "printer offline\n");
		return 0;
	}

	// cannot print if not ready
	if (!ready()) {
		fprintf(stderr, "printer not ready\n");
		return 0;
	}

	int pagesPerSheet = (duplexMode) ? 2 : 1;
	int pagesPrinted = std::min(nPages, nSheets*pagesPerSheet);
	fprintf(stdout, "DuplexPrinter printed %d pages\n", pagesPrinted);
	nSheets -= ceil(pagesPrinted/static_cast<double>(pagesPerSheet));
	return pagesPrinted;
}

} /* namespace CS_5004 */
