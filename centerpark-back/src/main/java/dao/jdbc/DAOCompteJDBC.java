package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOCompte;
import model.Client;
import model.Compte;
import model.Staff;

public class DAOCompteJDBC implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id_compte=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("client")) 
				{
					c = new Client(rs.getInt("id_compte"),rs.getString("mail"),rs.getString("password"),rs.getString("tel"),rs.getString("numero"),rs.getString("voie"),rs.getString("cp"),rs.getString("ville"));

				}
				else if (rs.getString("type_compte").equals("staff"))
				{
					c = new Staff(rs.getInt("id_compte"),rs.getString("mail"),rs.getString("password"),rs.getString("metier"));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {
		Compte c = null;
		List<Compte> comptes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("client")) 
				{
					c = new Client(rs.getInt("id_compte"),rs.getString("mail"),rs.getString("password"),rs.getString("tel"),rs.getString("numero"),rs.getString("voie"),rs.getString("cp"),rs.getString("ville"));

				}
				else if (rs.getString("type_compte").equals("staff"))
				{
					c = new Staff(rs.getInt("id_compte"),rs.getString("mail"),rs.getString("password"),rs.getString("metier"));
				}
				comptes.add(c);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public Compte insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			if(c instanceof Client)
			{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (mail,password,tel,numero,voie,cp,ville,type_compte) VALUES (?,?,?,?,?,?,?,?) ");

				Client client = (Client) c;

				ps.setString(1,client.getMail());
				ps.setString(2, client.getPassword());
				ps.setString(3, client.getTel());
				ps.setString(4,client.getAdresse().getNumero());
				ps.setString(5,client.getAdresse().getVoie());
				ps.setString(6, client.getAdresse().getCp());
				ps.setString(7,client.getAdresse().getVille());
				ps.setString(8, "client");

				ps.executeUpdate();
				ps.close();
			}
			else if(c instanceof Staff)
			{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (mail,password,metier,type_compte) VALUES (?,?,?,?) ");

				Staff staff = (Staff) c;
				ps.setString(1,staff.getMail());
				ps.setString(2, staff.getPassword());
				ps.setString(3,staff.getMetier());
				ps.setString(4, "staff");

				ps.executeUpdate();
				ps.close();
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			if(c instanceof Client)
			{
				PreparedStatement ps = conn.prepareStatement("Update compte set mail=?, password=?, tel=? , numero=?, voie=? , cp=? , ville=? , type_compte=? where id_compte=?");

				Client client = (Client) c;

				ps.setString(1,client.getMail());
				ps.setString(2, client.getPassword());
				ps.setString(3, client.getTel());
				ps.setString(4,client.getAdresse().getNumero());
				ps.setString(5,client.getAdresse().getVoie());
				ps.setString(6, client.getAdresse().getCp());
				ps.setString(7,client.getAdresse().getVille());
				ps.setString(8, "client");
				ps.setInt(9, c.getNumero());

				ps.executeUpdate();
				ps.close();
			}
			else if(c instanceof Staff)
			{
				PreparedStatement ps = conn.prepareStatement("Update compte set mail=?, password=?, metier=?, type_compte=? where id_compte=?");

				Staff staff = (Staff) c;
				ps.setString(1,staff.getMail());
				ps.setString(2, staff.getPassword());
				ps.setString(3,staff.getMetier());
				ps.setString(4, "staff");
				ps.setInt(5, c.getNumero());

				ps.executeUpdate();
				ps.close();
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id_compte=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public Compte seConnecter(String mail,String password) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where mail=? and password=?");
			ps.setString(1, mail);
			ps.setString(2,password);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("client")) 
				{
					c = new Client(rs.getInt("id_compte"),rs.getString("mail"),rs.getString("password"),rs.getString("tel"),rs.getString("numero"),rs.getString("voie"),rs.getString("cp"),rs.getString("ville"));

				}
				else if (rs.getString("type_compte").equals("staff"))
				{
					c = new Staff(rs.getInt("id_compte"),rs.getString("mail"),rs.getString("password"),rs.getString("metier"));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
