package com.github.edy.model.dto;

import com.github.edy.model.ClientModel;

import java.util.UUID;

public record ClientCreate(

        String name, // final
        String email, // final
        String cpf, // final
        String phone

) {

    public ClientCreate {

        // validating the name field
        if (name == null || name.isBlank()) { throw new IllegalArgumentException("O campo nome não pode ser nulo"); }
        if (name.length() < 5 || name.length() > 70) { throw new IllegalArgumentException("O campo nome deve ter entre 5 - 70 caracteres"); }


        // validating the email field
        String emailRegex = "^[A-Za-z0-9+_,-]+@(.+)$";
        if (email == null || !email.matches(emailRegex)) { throw new IllegalArgumentException("O e-mail é inválido"); }
        if (email.length() < 10 || email.length() > 50) { throw new IllegalArgumentException("O campo e-mail deve ter entre 10 - 50 caracteres"); }


        // validating the cpf field
        if (cpf == null || !cpf.matches("\\d{11}")) { throw new IllegalArgumentException("O campo cpf deve ter exatamente 11 caracteres"); }


        // validating the phone field
        // (!telefone.matches("\\d{10}|\\d{11}"))
        if (phone == null || !phone.matches("^\\d{10}$|^\\d{11}$")) { throw new IllegalArgumentException("O campo phone deve ter entre 10 - 11 caracteres"); }


        name = name.trim().toUpperCase();
        email = email.trim().toLowerCase();
        cpf = applayCpfMask(cpf.trim());
        phone = applayPhoneMask(phone.trim());
    }

    private static String applayCpfMask(String cpfMask) {
        return cpfMask.substring(0, 3) + "." + cpfMask.substring(3, 6) + "." +
                cpfMask.substring(6, 9) + "-" + cpfMask.substring(9, 11);
    }

    private static String applayPhoneMask(String phoneMask) {
        return "(" + phoneMask.substring(0, 2) + ") " + phoneMask.substring(2, 7) + "-" + phoneMask.substring(7, 11);
    }

    public ClientModel toentity() {
        return new ClientModel(name, email, cpf, phone);
    }

}
