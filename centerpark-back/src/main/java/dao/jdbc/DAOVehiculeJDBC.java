package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOVehicule;
import model.Vehicule;

public class DAOVehiculeJDBC implements IDAOVehicule{

	@Override
	public Vehicule findById(Integer id) {
		Vehicule v=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from vehicule where id_vehicule =?");
			ps.setInt(1, id);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				v=new Vehicule(rs.getInt("id_vehicule"),rs.getString("model"));			
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;

	}

	@Override
	public List<Vehicule> findAll() {


		List<Vehicule> vehicules = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from vehicule");


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Vehicule v=new Vehicule(rs.getInt("id_vehicule"),rs.getString("model"));	
				vehicules.add(v);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicules;
	}


	@Override
	public Vehicule insert(Vehicule v) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO vehicule (model) VALUES (?)");
			ps.setString(1,v.getModel());
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Vehicule update(Vehicule v) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE vehicule set model=? where id_vehicule=?");
			//UPDATE `vehicule` SET `id_vehicule`='[value-1]',`model`='[value-2]' WHERE 1
			ps.setString(1, v.getModel());
			ps.setInt(2,v.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM vehicule WHERE id_vehicule=?");
			//DELETE FROM `vehicule` WHERE 0

			ps.setInt(1, id);

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
