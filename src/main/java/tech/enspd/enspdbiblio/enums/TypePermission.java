package tech.enspd.enspdbiblio.enums;

import lombok.Getter;

public enum TypePermission {
    ADMINISTRATEUR_CREATE,
    ADMINISTRATEUR_READ,
    ADMINISTRATEUR_UPDATE,
    ADMINISTRATEUR_DELETE,

    MANAGER_CREATE,
    MANAGER_READ,
    MANAGER_UPDATE,
    MANAGER_DELETE,

    USER_READ_MEMOIRE;

    @Getter
    private String libelle;
}
