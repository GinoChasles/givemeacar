package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends BaseCrudRepository<Brand> {
}