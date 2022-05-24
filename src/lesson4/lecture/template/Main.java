package lesson4.lecture.template;

/** Data is obtained in various ways and, in a uniform way, written
 *  to an Excel spreadsheet.
 */
public class Main {

	public static void main(String[] args) {

		DataParser csvDataParser = new CSVDataParser();
		csvDataParser.parseDataAndGenerateOutput();
		System.out.println("**********************");
		DataParser databaseDataParser = new DatabaseDataParser();
		databaseDataParser.parseDataAndGenerateOutput();
	}

}
