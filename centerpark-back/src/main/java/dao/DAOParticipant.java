package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.Participant;

public class DAOParticipant implements IDAO<Participant, Integer> {

	@Override
	public Participant findById(Integer id) {
		Participant p = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from participant where id_participant=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				p = new Participant(id,rs.getString("nom"),rs.getString("prenom"), rs.getInt("age"));
			}


			rs.close();
			ps.close();
			conn.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
		return p;

	}

	@Override
	public List<Participant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participant insert(Participant p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO participant (nom, prenom, age) VALUES (?,?,?) ",Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setInt(3, p.getAge());


			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				p.setId(rs.getInt((1)));
			}
			ps.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void update(Participant o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
