package br.com.gubee.interview.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "power_stats")
@EntityListeners(AuditingEntityListener.class)
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String race;

    @NotBlank
    private Long power_stats_id;

    @NotBlank
    private Boolean enable;
    @NotBlank
    private Long created_at;
    @NotBlank
    private Long updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}