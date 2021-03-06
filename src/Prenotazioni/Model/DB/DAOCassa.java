package Prenotazioni.Model.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Prenotazioni.Model.Beans.Cassa;

public class DAOCassa {
	
	public DAOCassa() {		
	}
	
	public Cassa leggiCassa() {
		Connection conn = DataSource.getConnection();
		double disponibilitā = 0;
		try {
			PreparedStatement stat = conn.prepareStatement("select disponibilitā from cassa");
			ResultSet res = stat.executeQuery();
			if(res.next()) 
				disponibilitā = res.getDouble("disponibilitā");
			
			
			conn.close();
			
		} catch (SQLException e) {
			System.err.println("Errore connessione al DB!");
		}
		
		return new Cassa(disponibilitā);

	}
	
	public void aggiornaCassa(Cassa c) {
		
		try {
			Connection conn = DataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement("update cassa set disponibilitā = " + c.getDisponibilitā());
			int esito = stat.executeUpdate();
			if(esito!=1)
				throw new SQLException("Update cassa non effettuato");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
