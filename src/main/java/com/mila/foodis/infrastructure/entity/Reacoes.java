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
    public UUID id = UUID.randomUUID();
    public String emoji;
    public UUID user_id;
    public Date data_criacao;

}
