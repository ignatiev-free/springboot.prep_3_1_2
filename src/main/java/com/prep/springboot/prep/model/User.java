package com.prep.springboot.prep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Table(name = "users")
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull(message = "У User нет имени")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "Имя должно содержать только буквы")
    private String name;

    @Column
    @NotNull(message = "У User нет фамилии")
    @Size(min = 2, max = 50, message = "Фамилия должна содержать от 2 до 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "Фамилия должна содержать только буквы")
    private String surname;

    @Column
    @NotNull(message = "У User нет возраста")
    @Min(value = 1, message = "Возраст должен быть больше 0")
    private int age;

}
