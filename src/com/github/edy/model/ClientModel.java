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

        if (this.getName() == null || this.getName().trim().isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (this.getName().trim().length() < 5 || this.getName().trim().length() > 70) {
            throw new IllegalArgumentException("O campo nome deve conter entre 5 e 70 caracteres");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (this.getEmail() == null || !this.getEmail().matches(emailRegex)) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (this.getEmail().length() < 5 || this.getEmail().trim().length() > 50) {
            throw new IllegalArgumentException("O e-mail Deve conter entre 5 e 50 caracteres");
        }

        cpfMask.matches("\\d{11}");
        if (cpfMask.length() != 11) {
            throw new IllegalArgumentException("Formato inválido o cpf deve conter 11 caracteres");
        }


        phoneMask.matches("\\d{11}");
        if (phoneMask.length() != 11) {
            throw new IllegalArgumentException("O campo phone deve conter exatamente 11 caracteres");
        }

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
