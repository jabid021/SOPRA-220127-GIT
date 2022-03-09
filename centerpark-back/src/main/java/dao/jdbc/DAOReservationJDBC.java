package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOActivite;
import dao.IDAOCompte;
import dao.IDAOParticipant;
import dao.IDAOReservation;
import model.Activite;
import model.Client;
import model.Participant;
import model.Reservation;
import model.Statut;
import util.Context;

public class DAOReservationJDBC implements IDAOReservation{

	


	@Override
	public Reservation findById(Integer id) {
		IDAOParticipant daoParticipant = Context.getSingleton().getDaoParticipant();
		IDAOActivite daoActivite = Context.getSingleton().getDaoActivite();
		IDAOCompte daoCompte = Context.getSingleton().getDaoCompte();
		Reservation r = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where id_reservation = ?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				Activite a = daoActivite.findById(rs.getInt("activite_fk"));
				Client c = (Client) daoCompte.findById(rs.getInt("client_fk"));
				Participant p = daoParticipant.findById(rs.getInt("participant_fk"));

				String statut = rs.getString("statut");

				r = new Reservation(rs.getInt("id_reservation"),a,c,p,rs.getInt("note"),Statut.valueOf(statut),LocalDate.parse(rs.getString("date_reservation")));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reservation> findAll() {
		return null;
	}

	@Override
	public Reservation insert(Reservation r) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reservation (note,date_reservation,statut,client_fk,activite_fk,participant_fk) VALUES (?,?,?,?,?,?)");

			ps.setObject(1,r.getNote());
			ps.setString(2, r.getDate().toString());
			ps.setString(3, r.getStatut().toString());
			ps.setInt(4, r.getClient().getNumero());
			ps.setInt(5, r.getActivite().getId());
			ps.setInt(6, r.getParticipant().getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;

	}

	@Override
	public Reservation update(Reservation r) {
		return null;
	}

	@Override
	public void delete(Integer id) {

	}

	public List<Reservation> findAllReservationClient(int id) {	
		IDAOParticipant daoParticipant = Context.getSingleton().getDaoParticipant();
		IDAOActivite daoActivite = Context.getSingleton().getDaoActivite();
		IDAOCompte daoCompte = Context.getSingleton().getDaoCompte();
		List<Reservation> reservations = new ArrayList();
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where client_fk = ?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Activite a = daoActivite.findById(rs.getInt("activite_fk"));
				Client c = (Client) daoCompte.findById(rs.getInt("client_fk"));
				Participant p = daoParticipant.findById(rs.getInt("participant_fk"));

				String s = rs.getString("statut");

				Reservation r = new Reservation(rs.getInt("id_reservation"),a,c,p,(Integer) rs.getObject("note"),Statut.valueOf(s),LocalDate.parse(rs.getString("date_reservation")));
				reservations.add(r);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reservations;
	}
}