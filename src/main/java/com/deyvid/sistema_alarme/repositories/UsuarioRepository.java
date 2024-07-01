package com.deyvid.sistema_alarme.repositories;

import com.deyvid.sistema_alarme.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    /*
    @Query(value = "SELECT CASE WHEN COUNT(1)>0 THEN 'true' ELSE 'false' END FROM usuarios WHERE id = :id", nativeQuery = true)
    public boolean exist(Integer id);
     */

    @Query(value = "SELECT * FROM tb_usuarios WHERE email = :email AND senha = :senha", nativeQuery = true)
    public Usuario login(String email, String senha);
}
