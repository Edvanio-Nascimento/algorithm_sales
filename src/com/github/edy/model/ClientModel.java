package com.github.edy.model;

import java.util.UUID;

public class ClientModel extends Auditing{

    private final UUID id;
    private final String name;
    private final String email;
    private final String cpf;
    private String phone;

    public ClientModel(String name, String email, String cpf, String phone) {
        super();
        this.id = UUID.randomUUID();
        this.name = name.toUpperCase();
        this.email = email.trim().toLowerCase();
        this.cpf = cpf;
        this.phone = phone;

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
