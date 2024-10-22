package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Usuario;
import com.sistema.caixa.projection.CustomerMinProjection;
import com.sistema.caixa.projection.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(nativeQuery = true, value = "SELECT nome FROM tb_usuarios WHERE UPPER(nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    List<CustomerMinProjection> projection(String nome);
    @Query(nativeQuery = true, value = """
            SELECT tb_usuarios.email AS usuarionome, tb_usuarios.password, tb_role.id AS roleId, tb_role.authority
            FROM tb_usuarios
            INNER JOIN tb_usuario_role ON tb_usuarios.id = tb_usuario_role.usuario_id
            INNER JOIN tb_role ON tb_role.id = tb_usuario_role.role_id
            WHERE tb_usuarios.email = :email
            """)
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
