package com.example.demo.entity;

//id-long-pk
//name-st-uniq
//email-st-uniq
//pwd-st-hash
//role-enum-customer,agent,admin
@Entity
public class User{
    @Id
    @GeneratedValue(Strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    //private enum role;
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getmail(){
        return email;
    }
    public String getpa

}