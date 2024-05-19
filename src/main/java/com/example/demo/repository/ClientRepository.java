package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


//    @Query("select p from Post p where p.title = :title")
//    List<Post> findByTitle(@Param("title") String title);

    @Query("select C from Client C")
    List<Client> findAllClients(Pageable pageable);

}
