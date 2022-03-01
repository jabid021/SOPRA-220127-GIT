package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Ecureuil;
import model.Sanglier;
import model.Serpent;

public class DAOAnimal implements IDAO<Animal, Integer> {


	@Override
	public Animal findById(Integer id) {

		Animal a = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from animal where id_animal=?");
			ps.setInt(1, id);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_animal").equals("Sanglier")) 
				{
					a = new Sanglier(rs.getInt("id_animal"),rs.getString("nom"));

				}
				else if (rs.getString("type_animal").equals("Ecureuil"))
				{
					a = new Ecureuil(rs.getInt("id_animal"),rs.getString("nom"));
				}

				else if (rs.getString("type_animal").equals("Serpent"))
				{
					a = new Serpent(rs.getInt("id_animal"),rs.getString("nom"));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;

	}

	@Override
	public List<Animal> findAll() {

		List<Animal> animal = new ArrayList();
		Animal a = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from animal");


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_animal").equals("Sanglier")) 
				{
					a = new Sanglier(rs.getInt("id_animal"),rs.getString("nom"));

				}
				else if (rs.getString("type_animal").equals("Ecureuil"))
				{
					a = new Ecureuil(rs.getInt("id_animal"),rs.getString("nom"));
				}

				else if (rs.getString("type_animal").equals("Serpent"))
				{
					a = new Serpent(rs.getInt("id_animal"),rs.getString("nom"));
				}
				animal.add(a);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return animal;



	}

	@Override
	public Animal insert(Animal c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			if(c instanceof Ecureuil)
			{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO animal (nom,type_animal) VALUES (?,?) ");

				Ecureuil ecureuil=(Ecureuil) c;
				ps.setString(1,ecureuil.getNom());
				ps.setString(2, "Ecureuil");

				ps.executeUpdate();
				ps.close();
				conn.close();
			}
			else if(c instanceof Serpent)
			{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO animal (nom,type_animal) VALUES (?,?) ");

				Serpent serpent=(Serpent) c;
				ps.setString(1,serpent.getNom());
				ps.setString(2, "Serpent");

				ps.executeUpdate();
				ps.close();
				conn.close();
			}
			else if(c instanceof Sanglier)
			{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO animal (nom,type_animal) VALUES (?,?) ");

				Sanglier sanglier= (Sanglier) c;
				ps.setString(1,sanglier.getNom());
				ps.setString(2, "Serpent");

				ps.executeUpdate();
				ps.close();
				conn.close();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Animal a) {
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

				PreparedStatement ps = conn.prepareStatement("Update animal set nom=?, type_animal=? where id_animal=?");
				ps.setString(1,a.getNom());
				ps.setString(2, a.getClass().getSimpleName());
				ps.setInt(3, a.getId());


				ps.executeUpdate();
				ps.close();


				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(Integer id) {
		try {	
			boolean test = false;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE from animal where id_animal=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
			test = true;
			if (test=true) {System.out.println("L'animal "+id+" est mort D:");}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cet animal a un planning chargé !");
		}


	}


}

