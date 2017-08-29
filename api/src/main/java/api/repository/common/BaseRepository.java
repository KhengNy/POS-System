package api.repository.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    <S extends T> S save(S entity);

    T findOne(ID primaryKey);

    Page<T> findAll(Pageable pageable);

    void delete(T entity);

//    Long deleteOne(ID primaryKey);

    boolean exists(ID primaryKey);

    Page<T> findAllByStatus(Byte status, Pageable pageable);

//    Page<T> findAll(Sort sort, Pageable pageable);
}
