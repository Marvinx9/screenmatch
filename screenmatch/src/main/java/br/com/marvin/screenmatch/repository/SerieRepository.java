package br.com.marvin.screenmatch.repository;

import br.com.marvin.screenmatch.model.Categoria;
import br.com.marvin.screenmatch.model.Episodio;
import br.com.marvin.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    @Query("""
            select
            	s
            from Serie s
            where s.totalTemporadas <= :totalTemporadas
            and s.avaliacao >= :avaliacao""")
    List<Serie> seriesPorTemporadaEAvaliacao(int totalTemporadas, double avaliacao);

    @Query("""
            select
            	e
            from Serie s join s.episodios e
            where e.titulo ilike %:trechoEpisodio%
            """)
    List<Episodio> episodioPorTrecho(String trechoEpisodio);

    @Query("""
            select
                e
            from Serie s join s.episodios e
            where s = :serie
            order by e.avaliacao desc
            limit 5
            """)
    List<Episodio> topEpisodiosPorSerie(Serie serie);
}
