package org.example.user.api;

public class User {
    private String id;
    private String name;
    private String tel;
    private String email;

    public User(){

    }

    public User(String id,String name,String tel,String email){
        this.id=id;
        this.name=name;
        this.tel=tel;
        this.email=email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
