package SerializationDeserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Persist {

	public static void main(String args[]){  
		  try{  
		  //Creating the object  
		  Student s1 =new Student(211,"ravi");  
		  //Creating stream and writing the object  
		  FileOutputStream fout=new FileOutputStream("f.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(fout);  
		  out.writeObject(s1);  
		  out.flush();  
		  //closing the stream  
		  out.close();  
		  System.out.println("success");  
		  }catch(Exception e){System.out.println(e);}  
		 }  
}
//reference: https://dzone.com/articles/serialization-amp-de-serialization-in-java
//reference: https://www.javatpoint.com/serialization-in-java
