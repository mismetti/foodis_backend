package com.mila.foodis.infrastructure.repository;

import com.mila.foodis.infrastructure.entity.Post;
import com.mila.foodis.infrastructure.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Post findById();

    List<Post> findPostsByUsuarioId(String idUsuario);


}
