/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;

/**
 *
 * @author USER
 */
public interface EPSDAO {
    
    public List<Eps> loadAll();
    public Eps load();
    public void loadByID();
    public void save();
    public void update();
    
    
    
}
