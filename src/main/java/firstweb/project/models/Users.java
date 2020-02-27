package firstweb.project.models;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private int id;

    private  String email;
    private String password;

    private boolean active;

    private String roles;

    @Transient
    private String status;
    public boolean isActive() {
        return active;
    }

    public Users setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public Users setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Users setStatus(String status) {
        this.status = status;
        return this;
    }

    public Users(){

    }

    public Users(int id ,String email,String password,boolean active,String roles) {
        this.id=id;
        this.email=email;
        this.password=password;
        this.active=active;
        this.roles=roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Users setId(int id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
