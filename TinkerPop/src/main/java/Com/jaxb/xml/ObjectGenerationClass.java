package Com.jaxb.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectGenerationClass {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
      JAXBContext jcontent=JAXBContext.newInstance(Object.class);
      Marshaller Obj=jcontent.createMarshaller();
      Obj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      Object obj1=new Object("1404","9904","ETL_TBL1_to_TBL2","schema-none://GRAPHML/orionds/1","schema-none://GRAPHML/orionds","N/A","N/A","N/A");
      try {
		Obj.marshal(obj1, new FileOutputStream("student.xml"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	}

}
