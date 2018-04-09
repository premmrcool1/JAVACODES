package com.salesforce.object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.fasterxml.jackson.databind.JsonNode;


public class RestClientCall
{
	private static final Class<?> thisClass = new Object() {}.getClass().getEnclosingClass();
//	private static final Logger logger = LogManager.getLogger(thisClass);

	private static final String MDAPI_HARVESTER_IMPORTS = "harvester/api/imports";
	private static final String MDAPI_HARVESTER_RUNS = "harvester/api/runs";
	private static final String MDAPI_HARVESTER_RUN = MDAPI_HARVESTER_RUNS + "/%s";
	private static final Integer MDAPI_HARVESTER_POLL_DELAY = 10000;
	
	private static final String MDA_AUTH_TOKEN = "mmx-wBRiHJNv23iEyg3fhPIhjw";
	private static final String MMXML_FILE_PATH = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\Salesforce\\ObjectXML\\ActivityHistory.xml";
	
	public static void main(String[] args) throws IOException, InterruptedException, JAXBException
	{
		String name="https://demo01.orionic.com";
		makeRequest(MMXML_FILE_PATH,name,MDA_AUTH_TOKEN);
	}

	static void makeRequest(String FilePath,String URLName,String AUTH_TOKEN )
			throws JAXBException, IOException, MalformedURLException, InterruptedException {
		//System.out.println(">>>Graphml File");
		
		RESTClient mdaClient = RESTClient.newClient(new URL(URLName));
		mdaClient.setHeaders("Authorization: Token token=" + AUTH_TOKEN);

		File mmxmlFile = new File(FilePath);
		importMMXML(mdaClient, mmxmlFile);
	}
	
	public static void importMMXML(RESTClient rest, File file) throws InterruptedException
	{
//		logger.info("Importing {} to {}", file.getAbsolutePath(), rest.getBaseUrl());
		
/*		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
			String input;
			System.out.println("File content");
			while((input = bufferedReader.readLine()) != null) {
				System.out.println(input);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception");
			e.printStackTrace();
		}*/
		
		MultiPart multiPart = new MultiPart();
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		multiPart.bodyPart(new FileDataBodyPart("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE));

		String url = String.format(MDAPI_HARVESTER_IMPORTS);
		Response response = rest.createBuilder(url).post(Entity.entity(multiPart, multiPart.getMediaType()));
		// TODO: error check response 
		String jResponse = response.readEntity(String.class);
		int status = response.getStatus();
		
		System.out.println("jresponse " + jResponse + "\nstatus " + status + ">>>" + response.getStatusInfo() + "<<<");
/*		String runId = jResponse.path("run_id").asText();
		String runStatus = "Q";

		while(StringUtils.equalsAnyIgnoreCase(runStatus, "Q", "R")) {
			Thread.sleep(MDAPI_HARVESTER_POLL_DELAY);

			String runUrl = String.format(MDAPI_HARVESTER_RUN, runId);
			Response runResponse = rest.createBuilder(runUrl).get();
			// TODO: error check response 
			JsonNode jRunResponse = runResponse.readEntity(JsonNode.class);
			runStatus = jRunResponse.get("status").asText();
//			logger.info("Run status: {}", runStatus);
		}
		logger.info("MMXML import finished with status: {}", runStatus);*/
	
	}
	
}