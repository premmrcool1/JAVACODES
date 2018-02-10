package Com.jaxb.xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MultipleRootElementJava {
	
	static ArrayList<Object> arraylist = new ArrayList<Object>();
	public MultipleRootElementJava() throws JAXBException {
		super();
		 Model m=new Model();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws JAXBException {
		
	    /*JAXBContext jcontent=JAXBContext.newInstance(Model.class);
	      Marshaller Obj=jcontent.createMarshaller();
	      Obj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);*/
	      //Object obj1=new Object("1404","9904","ETL_TBL1_to_TBL2","schema-none://GRAPHML/orionds/1","schema-none://GRAPHML/orionds","N/A","N/A","N/A");
	     /* Object obj1=new Object();
	      obj1.setName("ETL_TBL1_to_TBL2");
	      obj1.setType("1404");
	      Relation Rel=new Relation();
	      Rel.setType("1404");
	      Model m=new Model();
	      m.getObject().add(obj1);
	      m.getRelation().add(Rel);*/
	      /*Obj.marshal(m, System.out);

	      try {
			Obj.marshal(m, new FileOutputStream("student.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// TODO Auto-generated method stub
		MultipleRootElementJava mul=new MultipleRootElementJava();
        mul.ObjectCreation("ETL", "1404", "9904", "Schem-none", "schema 1");
        mul.ObjectCreation("ETL_TBL1", "1404", "9904", "Schem-none", "schema 1");
        mul.ObjectCreation("Customer_tbl1", "1411", "9904", "Schem-none", "schema 1");
        Model m=mul.addtion(arraylist);
        mul.XMlCreation(m);
	}
	public Object ObjectCreation(String Name,String Type,String Ptype,String ref,String pref)
	{
		Object obj1=new Object();
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
	public Model addtion(ArrayList<Object> arraylist2)
	{
		  Model m=new Model();
		  for(Object Str: arraylist2)
		  {
		     m.getObject().add(Str);
		  }
	      return m;
	}
	public void XMlCreation(Model m) throws JAXBException
	{
		 JAXBContext jcontent=JAXBContext.newInstance(Model.class);
	      Marshaller Obj=jcontent.createMarshaller();
	      Obj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 ((Marshaller) Obj).marshal(m, System.out);

	      try {
			((Marshaller) Obj).marshal(m, new FileOutputStream("student.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
