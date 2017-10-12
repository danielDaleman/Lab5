/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.PacienteDAO;
import edu.eci.pdsw.persistence.mybatis.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Paciente;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class PacienteDAOMyBATIS  implements PacienteDAO{
    
    @Inject
    private PacienteMapper pamap;

    @Override
    public List<Paciente> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente loadByID(int id, String tipoid) {
        return pamap.loadPacienteById(id, tipoid);
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Paciente p) {
        pamap.actualizarPaciente(p, "", new Date(02/02/02) , "");
    }

    
}
