package com.academy.terai.model;

import com.academy.terai.model.request.AccountRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Document(collection = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String id;
    private String name;
    private String lastName;
    @Indexed(unique = true)
    @Email
    private String email;
    private Integer reviewedApplications;
    private Date lastLoggedIn;
    private String password;
    private List<String> roles = new ArrayList<>();


    public Account(AccountRequest account) {
        this.name = account.getName();
        this.lastName = account.getLastName();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.roles = account.getRoles();
    }
}
