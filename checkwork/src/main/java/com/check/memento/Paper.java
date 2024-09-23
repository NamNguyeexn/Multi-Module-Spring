package com.check.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Paper {
    private String username;
    private String password;
    public Pencil save(){
        return new Pencil(username, password);
    }
    public void restore(Pencil pencil){
        this.username = pencil.getUsername();
        this.password = pencil.getPassword();
    }
    public String toString(){
        return username + " " + password;
    }
}
