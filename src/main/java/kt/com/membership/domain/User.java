package kt.com.membership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kt.com.membership.dto.LoginForm;
import kt.com.membership.dto.UserForm;
import kt.com.membership.exception.InvalidPasswordException;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @Column(nullable = false, unique = true, length = 20)
    private String userId;

    @JsonIgnore
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String phoneNumber;

    @Column(nullable = false, length = 20)
    private String callProd;

    @Column
    private boolean isMembershipUser;

    @Column
    private LocalDateTime joinDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public User() {
    }

    public User(UserForm userForm) {
        this.userId = userForm.getUserId();
        this.password = userForm.getPassword();
        this.name = userForm.getName();
        this.email = userForm.getEmail();
        this.phoneNumber = userForm.getPhoneNumber();
        this.callProd = userForm.getCallProd();
        this.isMembershipUser = false;
        this.joinDate = LocalDateTime.now();
    }

    //==생성 메소드==//
    public static User createUser(UserForm userForm) {
        return new User(userForm);
    }

    //==비지니스 로직==//
    public void checkPassword(LoginForm loginForm) throws InvalidPasswordException {
        if(!this.password.equals(loginForm.getPassword())){
            throw new InvalidPasswordException();
        }
    }

    public void updateUserInfo(UserForm userForm){
        this.email = userForm.getEmail();
        this.password = userForm.getPassword();
        this.name = userForm.getName();
        this.phoneNumber = userForm.getPhoneNumber();
        this.callProd = userForm.getCallProd();
    }

    public boolean alreadyMembershipUser(){
        if(this.isMembershipUser){
            return true;
        }else{
            return false;
        }
    }

    public void signUpMembership(){
        this.isMembershipUser = true;
    }
}
