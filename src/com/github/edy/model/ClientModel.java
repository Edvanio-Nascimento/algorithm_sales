package com.github.edy.model;

import java.util.UUID;

public class ClientModel extends Auditing{

    private final UUID id;
    private final String name;
    private final String email;
    private final String cpf;
    private String phone;

    public ClientModel(String name, String email, String cpfMask, String phoneMask) {
        super();
        this.id = UUID.randomUUID();
        this.name = name.toUpperCase();
        this.email = email.trim().toLowerCase();
        this.cpf = maskCpf(cpfMask);
        this.phone = maskPhone(phoneMask);        

    }

    public String maskCpf(String cpfPure) {
        return  cpfPure.substring(0, 3) + "." +
                cpfPure.substring(3, 6) + "."  +
                cpfPure.substring(6, 9) + "-" +
                cpfPure.substring(9, 11);

    }

    private String maskPhone(String phonePure) {
        return  "(" +
                phonePure.substring(0, 2) + ") " +
                phonePure.substring(2, 7) + "-" +
                phonePure.substring(7, 11) ;
    }

    // SETTERS


    public void setPhone(String phone) {
        this.phone = phone;
    }

    // GETTERS
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }
}
