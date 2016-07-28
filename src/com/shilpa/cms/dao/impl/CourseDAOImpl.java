
package com.shilpa.cms.dao.impl;

import com.shilpa.cms.dao.CourseDAO;
import com.shilpa.cms.entity.Course;


public class CourseDAOImpl implements CourseDAO {
    private int counter = 0;
    private Course[] courseList = new Course[10];
    

    @Override
    public boolean insert(Course c) {
        if (courseList.length== counter){
            return false;
        }
            courseList[counter]= c;
            counter++;
            return true;
        
    }

    

    @Override
    public boolean delete(int id) {
        for (int i =0; i<courseList.length;i++){
            Course c= courseList[i];
            if(c!= null && c.getId()== id){
            courseList[i]=null;
            return true;
        }
            
        }
        return false;
    }

    @Override
    public Course getById(int id) {
        for (int i =0; i<courseList.length;i++){
            Course c= courseList[i];
            if(c!= null && c.getId()== id){
            return c;
        }
            
        }
        return null;
    }

    @Override
    public Course[] getAll() {
        return courseList;
    }
    
}
