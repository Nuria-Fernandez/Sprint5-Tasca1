package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Repository;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t01.n01.Model.Domain.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, Integer> {
}
