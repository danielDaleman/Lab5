/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * 
 * CLASES DE EQUIVALENCIA
 *      CE1: Paciente no registrado
 *           Respuesta esperada: Una Excepcion
 *      
 *      CE2: La fecha final sea mayor a la fecha incial
 *           Respuesta esperada: True 
 *      
 *      CE3: Que el paciente  ya existe
 *           Respuesta esperada: Una Excepcion  
 */
public class ServiciosPacientesTest {
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test 
    public void testPacienteNoRegistrado() throws ExcepcionServiciosPacientes{
        ServiciosPacientesMock sm = new ServiciosPacientesMock();
        Consulta c = new Consulta(java.sql.Date.valueOf("2000-01-01"), "Dolor de estomago", 454);
        try{
            sm.agregarConsultaPaciente(123, "cc", c);
        }catch(ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(), "Paciente 123 no esta registrado");
        }                        
        
    }
    
}
