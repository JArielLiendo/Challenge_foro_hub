package com.forohub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t WHERE t.curso=:curso AND FUNCTION('YEAR', t.fechaDeCreacion) = :fecha AND t.estado=ACTIVO")
    List<Topico> buscarPorCursoYFecha(Curso curso, int fecha);
    @Query("SELECT t FROM Topico t WHERE t.estado=ACTIVO")
    Page<Topico> buscarTopicoPorEstadoActivo(Pageable paginacion);
    @Query("SELECT t FROM Topico t WHERE t.estado = ACTIVO ORDER BY t.fechaDeCreacion ASC LIMIT 10")
    List<Topico> listarPrimeros10Topicos();
    @Query("SELECT t FROM Topico t WHERE t.id=:id AND t.estado=ACTIVO")
    Optional<Topico> validarTopicoActivo(Long id);

}
