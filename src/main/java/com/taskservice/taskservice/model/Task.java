package com.taskservice.taskservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean isImportant;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Border border;

    @ElementCollection
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "emailList")
    private List<String> emailList;
}
