package com.src.transform;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Transform {
	
	private TransformerFactory factory;
	
	//Creates a new instance of the factory when object is created.
	public Transform(){
		factory = TransformerFactory.newInstance();
	}

	//Performs XSLT transformation.
	public String performTransform(String inputFile, String outFile, String xslFile) throws TransformerException, URISyntaxException, IOException{
		
		//Stream to read input from inputFile
		StreamSource inputText = new StreamSource(new File(inputFile));
		
		//Stream to output the result to outFile
		StreamResult result = new StreamResult(new File(outFile));
		
		//Stream to read xslt from xslFile
		StreamSource xslt = new StreamSource(new File(xslFile));
		
		//Creating a new transformer of the XSLT using TransformerFactory.  
		Transformer transformer = factory.newTransformer(xslt);
		
		//Transforms the input XML to resulting output XML based on the XSLT.
		transformer.transform(inputText, result);
		
		return "Transform Successful.";
		
	}
	
}
