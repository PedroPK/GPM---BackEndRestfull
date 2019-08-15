package br.com.tecdainfor.dao;

import java.util.List;

import br.com.tecdainfor.model.Monitor;

public interface MonitorDAO {

    public Monitor cadastrarMonitor(Monitor monitor);
		
	public Monitor alterarMonitor(Monitor monitor);
	
	public Monitor consultarMonitorCodigo(int id);
	
	public List<Monitor> consultarMonitorTomb(String tomb);
	
	public Monitor excluir(int id);
	
	public List<Monitor> listarMonitores();
	
	
}
