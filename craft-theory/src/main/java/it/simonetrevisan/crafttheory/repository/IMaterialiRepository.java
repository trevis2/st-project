package it.simonetrevisan.crafttheory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;

public interface IMaterialiRepository extends JpaRepository<MateriaPrima, Long>
{

}
