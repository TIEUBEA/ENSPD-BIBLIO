package tech.enspd.enspdbiblio.entities;

import jakarta.persistence.*;
import lombok.*;
import tech.enspd.enspdbiblio.enums.TypeDeRole;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeDeRole libelle;
}
