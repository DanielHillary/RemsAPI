package com.jovine.nafa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class Fixtures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fixtureId;
    private String fixName;
    private LocalDateTime fixtureDate;
    @Transient
    private List<Games> gamesList;

}
