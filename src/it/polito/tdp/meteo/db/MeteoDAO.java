package it.polito.tdp.meteo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MeteoDAO {

//	public List<Rilevamento> getAllRilevamenti() {
//
//		final String sql = "SELECT Localita, Data, Umidita FROM situazione ORDER BY data ASC";
//
//		List<Rilevamento> rilevamenti = new ArrayList<Rilevamento>();
//
//		try {
//			Connection conn = DBConnect.getInstance().getConnection();
//			PreparedStatement st = conn.prepareStatement(sql);
//
//			ResultSet rs = st.executeQuery();
//
//			while (rs.next()) {
//
//				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
//				rilevamenti.add(r);
//			}
//
//			conn.close();
//			return rilevamenti;
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	public List<Rilevamento> getAllRilevamentiLocalitaMese(int mese, String localita) {
//
//		return null;
//	}

	public Double getAvgRilevamentiLocalitaMese(int mese, String localita) {

		final String sql = "SELECT AVG(Umidita) AS media FROM situazione WHERE MONTH(Data)=? AND Localita=?";

		try {
			
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, mese);
			st.setString(2, localita);
			ResultSet rs = st.executeQuery();

			rs.next();
			
			Double media = rs.getDouble("media");
			
			rs.close();
			st.close();
			conn.close();
			
			return media;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}