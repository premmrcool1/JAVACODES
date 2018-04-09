package com.salesforce.object;


import org.apache.commons.cli.*;
/* 
* Stub program that reads command line arguments
*/
public class CommandLineProgram {
	private static Options options = null; // Command line options
	
	private static final String PROPERTIES_LOCATION_OPTION = "f";
	private static final String OUTPUT_FILE_OPTION = "o";
	private static final String DEFAULT_OUTPUT_FILE = "out.feed";
	
	private CommandLine cmd = null; // Command Line arguments
	
	private String outputFile = DEFAULT_OUTPUT_FILE;
	
	static{
		options = new Options();
		options.addOption(PROPERTIES_LOCATION_OPTION, true, 
				"Data file location");
		options.addOption(OUTPUT_FILE_OPTION, true, "Output file. " + DEFAULT_OUTPUT_FILE + " by default ");
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CommandLineProgram cliProg = new CommandLineProgram();
		cliProg.loadArgs(args);
	}
	
	/**
	 * Validate and set command line arguments.
	 * Exit after printing usage if anything is astray
	 * @param args String[] args as featured in public static void main()
	 */
	void loadArgs(String[] args){
		CommandLineParser parser = new PosixParser();
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.err.println("Error parsing arguments");
			e.printStackTrace();
			System.exit(1);
		}
		
		// Check for mandatory args
		
		if (! cmd.hasOption(PROPERTIES_LOCATION_OPTION)){
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java -jar this_jar.jar", options);
			System.exit(1);
		}
		
		if (cmd.hasOption(PROPERTIES_LOCATION_OPTION)){
		  String Pop=cmd.getOptionValue(PROPERTIES_LOCATION_OPTION);
		  System.out.println(Pop);
		}
		// Look for optional args.
		
		if (cmd.hasOption(OUTPUT_FILE_OPTION)){
			outputFile = cmd.getOptionValue(OUTPUT_FILE_OPTION);
			System.out.println(outputFile);
			
		}
	}
}