//6510405750 Phumrapee Soenvanichakul
package ku.cs.kafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;


@Data
@Entity
public class Member {


    @Id
    @GeneratedValue
    private UUID id;


    private String username;
    private String password;
    private String name;
    private String role;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String hashedPassword) {
        this.password = hashedPassword;
    }

}

