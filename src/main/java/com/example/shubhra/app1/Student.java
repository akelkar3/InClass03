package com.example.shubhra.app1;

import java.io.Serializable;

public class Student implements Serializable {

          String name , email , department;
    public int mood;


     public Student(String name, String email, String department, int mood)
        {
           this.name=name;
            this.email=email;
           this.department=department;
           this.mood=mood;
        }


   }
