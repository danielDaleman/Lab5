/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesMock;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Castiblanco  & Daniel Moreno
 * 
 * CLASES DE EQUIVALENCIA METODO REGISTRO DE CONSULTAS
 *      CE1: Paciente no registrado
 *           Respuesta esperada: Una Excepcion
 *      
 *      CE2: La fecha final sea mayor a la fecha incial
 *           Respuesta esperada: True 
 *    
 * 
 * CLASES DE EQUIVALENCIA METODO REGISTRO DE PACIENTES
 *      CE1: El paciente debe tener que tipp de id tiene
 *           Respuesta esperada: True
 *      CE2: Que paciente tenga nombre
 *           Respuesta esperada= True
 *      
 * 
 * 
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
        Consulta c = new Consulta(new Date(2000,01,01), "Dolor de estomago", 454);
        try{
            sm.agregarConsultaPaciente(123, "cc", c);
        }catch(ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(), "Paciente 123 no esta registrado");
        }
    }

    @Test 
    public void testFechaRegistradaDebeSerMenorAFechaActual() throws ParseException{
        Consulta con = new Consulta(java.sql.Date.valueOf("2018-01-01"), "Dolor de cabeza", 454);
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date actual= new Date();
        Date registrada= con.getFechayHora();
        String fechaActual = f1.format(actual);
        String fechaRegistrada = f1.format(registrada);
        
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date act = (Date) f2.parse(fechaActual);
        Date regis = (Date) f2.parse(fechaRegistrada);
        boolean res = act.before(regis);
        assertTrue(res);
        
    }
    
    
    @Test 
    public void testPacienteDebeTenerNombre() throws ExcepcionServiciosPacientes{
        ServiciosPacientesMock sm2 = new ServiciosPacientesMock();
        Eps eps1 = new Eps("Compensar", "7289374982-0");
        Paciente paciente1 = new Paciente(1111,"CC", "Juan", java.sql.Date.valueOf("2000-01-01"), eps1);
        sm2.registrarNuevoPaciente(paciente1);
        assertNotEquals(paciente1.getNombre(),"");
        
    }
    
    @Test
    public void testPacienteDebeTenerTipoId() throws ExcepcionServiciosPacientes{
        ServiciosPacientesMock sm2 = new ServiciosPacientesMock();
        Eps eps1 = new Eps("Compensar", "7289374982-0");
        Paciente paciente1 = new Paciente(1111,"CC", "Juan", java.sql.Date.valueOf("2000-01-01"), eps1);
        sm2.registrarNuevoPaciente(paciente1);
        assertNotEquals(paciente1.getTipoId() ,"");
    }  
}



    


