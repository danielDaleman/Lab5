/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.PacienteDAO;
import edu.eci.pdsw.persistence.mybatis.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import java.sql.Date;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author USER
 */
public class PacienteDAOMyBATIS  implements PacienteDAO{
    
    @Inject
    private PacienteMapper pamap;

    @Override
    public List<Paciente> loadAll() {
        List<Paciente> pacientes = null; 
        try{
            pacientes = pamap.loadPacientes();
        }catch(PersistenceException e){
            throw new PersistenceException("Error al cargar todos los pacientes",e);
        }        
        return pacientes;
    }

    @Override
    public void load(Paciente p) {
        Paciente paciente;
        try{
            pamap.insertarPaciente(p);
        }catch(PersistenceException e){
             throw new PersistenceException("Error al insertar paciente"+p.getId(),e);
        }        
        
    }

    @Override
    public Paciente loadByID(int id, String tipoid) throws PersistenceException {
        try{
            return pamap.loadPacienteById(id, tipoid);
        }catch(Exception e){
            throw new PersistenceException("Error al cargar el paciente por ID",e);
        }        
    }

    @Override
    public void save(Consulta c, int id, String tipoId, int costo) {
         try{
            pamap.insertConsulta(c, id, tipoId, costo);
                    
        }catch(Exception e){
            throw new PersistenceException("Error al guardar la consulta "+c.getId()+" al paciente "+id,e);
        }
    }

    @Override
    public void update(Paciente p) throws PersistenceException{
        try{
            pamap.actualizarPaciente(p, "", new Date(02/02/02) , "");
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el paciente "+p.getId(),e);
        }
    }

    
}
