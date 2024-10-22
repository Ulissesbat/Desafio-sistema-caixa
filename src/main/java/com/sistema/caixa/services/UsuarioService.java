package com.sistema.caixa.services;

import com.sistema.caixa.dto.UsuarioDto;
import com.sistema.caixa.dto.CustomerMinDto;
import com.sistema.caixa.entities.Role;
import com.sistema.caixa.entities.Usuario;
import com.sistema.caixa.projection.CustomerMinProjection;
import com.sistema.caixa.projection.UserDetailsProjection;
import com.sistema.caixa.repositories.UsuarioRepository;
import com.sistema.caixa.services.exception.DatabaseException;
import com.sistema.caixa.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;
    @Transactional
    public UsuarioDto insert(UsuarioDto dto){
        Usuario entity = new Usuario();

        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setEmail(dto.email());

        entity = repository.save(entity);

        return new UsuarioDto(entity);
    }
    @Transactional
    public UsuarioDto update(Long id, UsuarioDto dto) {

        Usuario entity = repository.getReferenceById(id);
        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setEmail(dto.email());

        entity = repository.save(entity);

        return new UsuarioDto(entity);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id) {
        if(! repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException("falha de integridade");
        }
    }
    @Transactional(readOnly = true)
    public Page<UsuarioDto>findAll(Pageable pageable){
        Page<Usuario>result = repository.findAll(pageable);
        return result.map(UsuarioDto::new);
    }

    @Transactional(readOnly = true)
    public UsuarioDto findById(Long id){
        Usuario cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new UsuarioDto(cliente);
    }

    @Transactional(readOnly = true)
    public List<CustomerMinDto> findByMin(String name) {
        List<CustomerMinProjection> projections = repository.projection(name);
        return projections.stream().map(CustomerMinDto::new).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if(result.isEmpty()){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(username);
        usuario.setPassword(result.get(0).getPassword());
        for(UserDetailsProjection projection : result){
            usuario.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return usuario;
    }
}
