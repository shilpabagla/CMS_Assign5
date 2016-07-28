
package com.shilpa.cms.dao;

import com.shilpa.cms.entity.Course;


public interface CourseDAO {
    
    boolean insert(Course c);
    boolean delete(int id);
    Course getById(int id);
    Course[] getAll();
}
