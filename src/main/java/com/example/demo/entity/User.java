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
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return passwork;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    

}