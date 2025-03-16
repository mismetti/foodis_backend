package com.mila.foodis.infrastructure.entity;

import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Comentario {

    @Id
    private String id;
    private String comentario;
    @DBRef
    private List<Reacoes> reacoes;
    @DBRef
    private List<Comentario> respostas;
    @DBRef
    private Usuario usuario;
    @DBRef
    private Post post;
    private LocalDateTime data_criacao;
}
