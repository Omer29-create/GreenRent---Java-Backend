package com.greenrent.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_cmessage")
public class ContactMessage implements Serializable { // Best practice: Bu entity'yi network'te isletmek icin

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id'lerin generate edilmesi icin
    private Long id;

    @Size(min = 1, max = 50, message = "Your Name '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide your name")
    @Column(length = 50, nullable = false)
    private String name;

    @Size(min = 5, max = 50, message = "Your Subject '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide your subject")
    @Column(length = 50, nullable = false)
    private String subject;

    // Mesajin Body'si icin
    @Size(min = 20, max = 200, message = "Your Message '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide message body")
    @Column(length = 200, nullable = false)
    private String body;

    @Email
    @Column(length = 50, nullable = false)
    private String email;
}
