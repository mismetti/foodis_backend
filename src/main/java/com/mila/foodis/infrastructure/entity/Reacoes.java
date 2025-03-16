package com.mila.foodis.infrastructure.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Document("reacoes")
public class Reacoes {

    @Id
    private String id;
    private String emoji;
    private UUID user_id;
    private Date data_criacao;

}
