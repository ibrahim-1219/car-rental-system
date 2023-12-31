package com.global.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "owners")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "driving_licence")
    private String drivingLicence;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\d{10}")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id",unique = true)
    @NotNull(message = "app user is mandatory")
    private AppUser appUser;

    @JsonManagedReference
    @OneToMany(mappedBy = "owner")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> car ;

}
