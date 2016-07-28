
package com.shilpa.cms;

import com.shilpa.cms.dao.CourseDAO;
import com.shilpa.cms.dao.impl.CourseDAOImpl;
import com.shilpa.cms.entity.Course;
import java.util.Scanner;


public class MainProgram {

    
    public static void main(String[] args) {
        CourseDAO courseDAO= new CourseDAOImpl();
        Scanner input= new Scanner(System.in);
        while(true){
        System.out.println("Enter your choice:");
        System.out.println("1. Add Course:");
        System.out.println("2. Delete Course:");
        System.out.println("3. Show all Course:");
        System.out.println("4. Search by Id:");
        System.out.println("5. Exit.");
        
        switch(input.nextInt()){
            case 1:
                System.out.println("Add the course:");
                Course c = new Course();
                System.out.println("Enter id:");
                c.setId(input.nextInt());
                System.out.println("Enter name:");
                c.setName(input.next());
                System.out.println("Enter description:");
                c.setDescription(input.next());
                System.out.println("Enter cost of course:");
                c.setPrice(input.nextDouble());
                System.out.println("Enter status:");
                c.setStatus(input.nextBoolean());
                if(courseDAO.insert(c)){
                    System.out.println("Successfully inserted!");
                }
                else{
                    System.out.println("Data exceeded the limit!!");
                }
            break;
            case 2:
              
                System.out.println("Enter the id of the Course to be deleted:");
                 int id= input.nextInt();
               
                   if( courseDAO.delete(id)){
                    System.out.println("Course deleted successfully!");}
                    
                
                else{
                    System.out.println("Id not found!");}
                    break;
            case 3 :
                System.out.println("Show all courses!");
                Course[] courses= courseDAO.getAll();
                for(int i= 0; i<courses.length;i++){
                    Course course= courses[i];
                    if(course!=null){
                        System.out.println("Id"+course.getId());
                        System.out.println("Name"+course.getName());
                        System.out.println("Description"+ course.getDescription());
                        System.out.println("Price"+course.getPrice());
                        System.out.println("Status"+course.isStatus());
                        
                    }
                
                }
            break;
            case 4:
               
        System.out.println("Enter the course's id:");
         int result= input.nextInt();
        Course c1 = courseDAO.getById(result);
                        
         if(c1!=null)
        {
             System.out.println("Course's details:");
            System.out.println("course name: "+ c1.getName());
            System.out.println("course's price: "+c1.getPrice());
            System.out.println("course's status: "+c1.isStatus());
            System.out.println("course's description: "+ c1.getDescription());
        }
        
        else{
            System.out.println("Course doesn't exist!");}
                break;
            case 5:
                System.out.println("Do you want to exit(y/n)?");
                if(input.next().equalsIgnoreCase("y")){
                    System.exit(0);
                }
            break;
                 }
        
        
        }
    }
    
}

