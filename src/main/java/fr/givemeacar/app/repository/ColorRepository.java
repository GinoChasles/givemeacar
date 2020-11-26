package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color,Integer> {

    public List<Color> findColorByName(String name);
}
