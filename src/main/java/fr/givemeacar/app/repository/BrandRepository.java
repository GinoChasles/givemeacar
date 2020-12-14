package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Brand;

public interface BrandRepository extends findByNameStartingWithRepository<Brand>,BaseCrudRepository<Brand> {
}