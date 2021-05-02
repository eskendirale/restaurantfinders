package InduScuad.com.restaurantfinders;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class UsersTable {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String username;
    @NotNull
    private String pwHash;
    private Date dateCreatedPassword;
    private Date dateModifiedPassword;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public UsersTable(){}

    public UsersTable(Date dateCreatedPassword,Date dateModifiedPassword,int id, String username, String password){
        this.id = id;
        this.dateCreatedPassword = dateCreatedPassword;
        this.dateModifiedPassword = dateModifiedPassword;
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreatedPassword() {
        return dateCreatedPassword = new Date();
    }

    public Date getDateModifiedPassword() {
        return dateModifiedPassword = new Date();
    }

    public String getUsername() {
        return username;
    }
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersTable that = (UsersTable) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

