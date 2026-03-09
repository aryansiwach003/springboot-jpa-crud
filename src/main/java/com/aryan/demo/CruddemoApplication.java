package com.aryan.demo;

import com.aryan.demo.dao.StudentDao;
import com.aryan.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao st){

		   return  runner->{


			  //creating database and saving jaava objects to the databse

		   Student t=new Student("terry","coat","terrycoat@12345");
			   st.save(t);
			  Student s=new Student("aryan","siwaxh","hello@123");

			   st.save(s);

			   // retrieving the objects using id from the database

			  int id0=s.getId();

			   System.out.println(id0);

			  Student mystud=st.findById(id0);
			   System.out.println(mystud);

			   // quering all the objects from the db

			   List<Student> l=st.findAll();

			   for(Student str:l){
				  System.out.println(str);
			   }

			   //quering the objects based on the lastName

			   List<Student> ll=st.findByLastName("Dos");

			   for(Student str:ll){
				   System.out.println(str);
			   }

			   // updating the objects

			   int id1=1;

			   Student myStudent =st.findById(id1);

			   myStudent.setFirstName("Scooby");

			   st.update(myStudent);

			   //deleting the object from the db;

			   int id2=3;
			   st.delete(id2);


			   int rows=st.deleteAll();
			   System.out.println("row count:"+rows);

		   };
	}



}
