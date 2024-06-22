package cl.chile.regioneschile.repository;

import cl.chile.regioneschile.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
