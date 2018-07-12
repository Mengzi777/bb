/*
 * DuplexPrinter.h
 *
 *  @since Jan 20, 2018
 *  @author philip gust
 */

#ifndef DUPLEXPRINTER_H_
#define DUPLEXPRINTER_H_

#include "Printer.h"

namespace CS_5004 {

/**
 *
 */
class DuplexPrinter: public Printer {
private:
	bool duplexMode = false;

public:
	/**
	 * Create a new printer.
	 */
	DuplexPrinter();

	/**
	 * Delete the printer.
	 */
	~DuplexPrinter();

	/**
	 * Determines whether printer is in duplex mode.
	 * In this mode, pages are printed on front and back.
	 *
	 * @return true if printer is in duplex mode.
	 */
	bool duplex() const;

	/**
	 * Determines whether printer is in duplex mode.
	 * In this mode, pages are printed on front and back.
	 *
	 * @return true if printer is in duplex mode.
	 */
	void duplex(bool duplexMode);

	/**
	 * Returns the printer model.
	 *
	 * @return the printer model
	 */
	const string &model() const;

	/**
	 * Printers the specified number of pages.
	 *
	 * @param nPages the number of pages to print
	 * @return the number of pages actually printed
	 */
	unsigned int print(unsigned int nPages);
};

} /* namespace CS_5004 */

#endif /* DUPLEXPRINTER_H_ */
