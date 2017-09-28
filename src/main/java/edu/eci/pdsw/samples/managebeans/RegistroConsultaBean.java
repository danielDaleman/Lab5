/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped

public class RegistroConsultaBean implements Serializable {

    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    private Consulta consulta;
    Set<Consulta> listaConsultas=new LinkedHashSet<>();;
    private int idConsulta;
    private Date fechaConsulta;
    private String descripcionConsulta;
    private long costo;
    
    
    //Datos Paciente
    private int idPaciente;
    private String tipoidPaciente;
    private String nombrePaciente;
    private Date fechaNacimiento;
    private Eps eps;
    private final List<Eps> epsRegistradas;
    private Paciente paciente;
    Set<Paciente> listaPacientes=new LinkedHashSet<>();;

    public Set<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(Set<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<Eps> getEpsRegistradas() {
        return epsRegistradas;
    }

    public RegistroConsultaBean() throws ExcepcionServiciosPacientes {
         epsRegistradas = servicepacientes.obtenerEPSsRegistradas(); 
    }
    //Pacientes
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoidPaciente() {
        return tipoidPaciente;
    }

    public void setTipoidPaciente(String tipoidPaciente) {
        this.tipoidPaciente = tipoidPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }
       
        
    public void agregarPaciente() throws ExcepcionServiciosPacientes{
        paciente = new Paciente(idPaciente,tipoidPaciente, nombrePaciente ,fechaNacimiento,eps);
        listaPacientes.add(paciente);
        servicepacientes.registrarNuevoPaciente(paciente);
    }

    //Consultas     
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Set<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(Set<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDescripcionConsulta() {
        return descripcionConsulta;
    }

    public void setDescripcionConsulta(String descripcionConsulta) {
        this.descripcionConsulta = descripcionConsulta;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;                
    }
    
    
    
    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public void agregarConsulta() throws ExcepcionServiciosPacientes{
        consulta = new Consulta();     
        listaConsultas.add(consulta);
        servicepacientes.agregarConsultaPaciente(idConsulta, descripcionConsulta, consulta);

    }



}
