package zw.apkmechanik.enrolment.domain.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/11
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,String> {
}
