package com.xml.gen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;

public class XMLGEN {
	
	static ArrayList<Object> arraylist = new ArrayList<Object>();
	static ArrayList<Relation> arraylist1 = new ArrayList<Relation>();
	ObjectFactory oF=new ObjectFactory();
	Model m=oF.createModel();
	public XMLGEN()  {
		super();
		 
	   

		// TODO Auto-generated constructor stub
	}
	/*public static void main(String[] args) throws JAXBException {
		

		XMLGEN mul=new XMLGEN();
        mul.ObjectCreation("ETL", "1404", "9904", "Schem-none", "schema 1");
        mul.ObjectCreation("ETL_TBL1", "1404", "9904", "Schem-none", "schema 1");
        mul.ObjectCreation("Customer_tbl1", "1411", "9904", "Schem-none", "schema 1");
        mul.RelationCreation("10",(short) 1404,(short) 151,"Schem-none","Schem-none");
        mul.addtion(arraylist);
        mul.Reladdtion(arraylist1);
        mul.XMlCreation();
        
	}*/
	public Object ObjectCreation(String Name,String Type,String Ptype,String ref,String pref)
	{
		Object obj1=oF.createObject();
	      obj1.setName(Name);
	      obj1.setType(Type);
	      obj1.setPtype(Ptype);
	      obj1.setRef(ref);
	      obj1.setPref(pref);
	      arraylist.add(obj1);
	      return obj1;
	      /*Relation Rel=new Relation();
	      Rel.setType("1404");*/
	     
		
	}
	public Relation RelationCreation(String Type,Short rtype,Short reltype,String ref,String relref)
	{
		Relation Rel=oF.createRelation();
	      Rel.setType(Type);
	      Rel.setRtype(rtype);
	      Rel.setReltype(reltype);
	      Rel.setRef(ref);
	      Rel.setRelref(relref);      
	      arraylist1.add(Rel);
	      return Rel;
	      /*Relation Rel=new Relation();
	      Rel.setType("1404");*/
	     
		
	}
	public Model addtion(ArrayList<Object> arraylist2)
	{
		  //Model m=new Model();
		  for(Object Str: arraylist2)
		  {
		     m.getObject().add(Str);
		  }
	      return m;
	}
	public Model Reladdtion(ArrayList<Relation> arraylist2)
	{
		  for(Relation Str: arraylist2)
		  {
		     m.getRelation().add(Str);
		  }
	      return m;
	}
	public void XMlCreation(String FileName,String Name,String Version,String ImplicitType,String Schemaref) throws JAXBException
	{
		 m.setName(Name);
		 m.setXsltVersion(Version);
		 m.setSchemaref(Schemaref);
		 m.setName(Name);
		 m.setImplicitTypes(ImplicitType);
		 
		 JAXBContext jcontent=JAXBContext.newInstance(Model.class);
		// XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
		 //XMLStreamWriter writer = outputFactory.createXMLStreamWriter();
		 
	      Marshaller Obj=jcontent.createMarshaller();
	      
	      Obj.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>");
	      Obj.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
	      Obj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	      Obj.setProperty("com.sun.xml.bind.namespacePrefixMapper", new PrefixMapper());
		 ((Marshaller) Obj).marshal(m, System.out);
		// ((Marshaller) Obj).marshal(m, writer);;
		 
	      try {
			((Marshaller) Obj).marshal(m, new FileOutputStream(FileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}

