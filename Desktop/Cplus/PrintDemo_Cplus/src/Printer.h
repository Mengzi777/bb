/*
 * Printer.h
 *
 *  @since Jan 20, 2018
 *  @author philip gust
 */

#ifndef PRINTER_H_
#define PRINTER_H_

#include <string>

using std::string;

namespace CS_5004 {

/**
 * This class defines a printer
 */
class Printer {
private:
	/** the offline status of the printer */
	bool offlineStatus = true;

protected:
	/** the number of sheets in the printer */
	unsigned int nSheets = 0;

public:
	/**
	 * Create a new printer.
	 */
	Printer();

	/**
	 * Delete the printer
	 */
	virtual ~Printer();

	/**
	 * Returns the printer model.
	 *
	 * @return the printer model
	 */
	virtual const string &model() const;

	/**
	 * Determines whether the printer is ready.
	 * @return true if the printer is ready
	 */
	bool ready() const;

	/**
	 * Determines whether the printer is offline.
	 *
	 * @return true if the printer is offline
	 */
	bool offline() const;

	/**
	 * Sets the offline status of the printer.
	 *
	 * @param offlineStatus the offline status
	 */
	void offline(bool offlineStatus);

	/**
	 * Returns the sheet capacity of the printer.
	 *
	 * @return the sheet capacity of the printer
	 */
	unsigned int sheetCapacity() const;

	/**
	 * Returns the number of sheets available.
	 * @return the nuber of seets available
	 */
	unsigned int sheetsAvailable() const;

	/**
	 * Add the number of sheets to the printer.
	 *
	 * @param nSheets the number of sheets to add
	 * @return the actual number of sheets added
	 */
	unsigned int addSheets(unsigned int nSheets = 0);

	/**
	 * Printers the specified number of pages.
	 *
	 * @param nPages the number of pages to print
	 * @return the number of pages actually printed
	 */
	virtual unsigned int print(unsigned int nPages);
};

} /* namespace CS_5004 */

#endif /* PRINTER_H_ */
