package com.src.transform;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

public class XsltTranform {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Accept the input file name/location
		System.out.println("Enter the input file name:");
		String inputFile = scanner.nextLine();
		
		//Accept the output file name/location
		System.out.println("Enter the output file name:");
		String outputFile =  scanner.nextLine();
		
		//Accept the XSLT file name/location
		System.out.println("Enter the XSLT file name:");
		String xsltFile = scanner.nextLine();
		
		//Initializing Transform object to call the transform method
		Transform transform = new Transform();
		try {
			//Perform Transformation
			String result = transform.performTransform(inputFile, outputFile, xsltFile);
			
			//Prints successful message if transformation is successful.
			System.out.println(result);
			
		} catch (IOException e) {
			System.out.println("Error finding the file: " + e.getMessage());
			e.printStackTrace();
		} catch (TransformerException e) {
			System.out.println("Error while transforming the file: " + e.getMessage());
			e.printStackTrace();
		} catch (URISyntaxException e) {
			System.out.println("Exception in the URI Syntax: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
