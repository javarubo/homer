package am.basic.web.model;



import org.springframework.stereotype.Component;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "test")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false,updatable = false)
    private long id;
    @NotNull
    private String name;
/*@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<PhoneNumber> phoneNumber;*/
    private String surname;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String code;
    @NotNull
    private String age;
   /* @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Card card;*/


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
*/
   /* public List<PhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumber> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}
