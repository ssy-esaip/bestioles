package org.esaip.b32526.bestioles.dal;

import jakarta.transaction.Transactional;
import org.esaip.b32526.bestioles.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    List<Species> findByCommonName(String name);
    List<Species> findByCommonNameOrLatinName(String cName, String lName);
    @Transactional
    void deleteAllByCommonName(String name);
}
