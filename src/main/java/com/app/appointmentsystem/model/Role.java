package com.app.appointmentsystem.model;

public enum Role {
    CLIENT, ADMIN;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
