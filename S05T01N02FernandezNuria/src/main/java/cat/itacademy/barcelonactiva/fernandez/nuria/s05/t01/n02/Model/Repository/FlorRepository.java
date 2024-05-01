package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Repository;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n02.Model.Domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {
}
