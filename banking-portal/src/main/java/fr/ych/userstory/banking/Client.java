package fr.ych.userstory.banking;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return login;
    }

    public void setFirstName(String firstName) {
        this.login = firstName;
    }

    public String getLastName() {
        return password;
    }

    public void setLastName(String lastName) {
        this.password = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
