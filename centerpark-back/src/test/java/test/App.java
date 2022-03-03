package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import dao.IDAOActivite;
import dao.IDAOAnimal;
import dao.IDAOCompte;
import dao.IDAOParticipant;
import dao.IDAOReservation;
import dao.IDAOVehicule;
import model.Activite;
import model.Animal;
import model.Aquatique;
import model.Client;
import model.Compte;
import model.Ecureuil;
import model.Meteo;
import model.Participant;
import model.Reservation;
import model.Safari;
import model.Sanglier;
import model.Serpent;
import model.Staff;
import model.Vehicule;
import util.Context;


public class App {

	static Compte connected;
	static IDAOCompte daoCompte = Context.getSingleton().getDaoCompte();
	static IDAOActivite daoActivite = Context.getSingleton().getDaoActivite();
	static IDAOAnimal daoAnimal = Context.getSingleton().getDaoAnimal();
	static IDAOReservation daoReservation = Context.getSingleton().getDaoReservation();
	static IDAOParticipant daoParticipant = Context.getSingleton().getDaoParticipant();
	static IDAOVehicule daoVehicule = Context.getSingleton().getDaoVehicule();

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		String saisie= sc.nextLine();
		return saisie;
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		double saisie= sc.nextDouble();
		return saisie;
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int saisie= sc.nextInt();
		return saisie;
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}

	public static void menuPrincipal() {
		System.out.println("Application CENTER PARK");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Quitter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 -> seConnecter();
		case 2 -> inscription();
		case 3 -> System.exit(0);
		}
		menuPrincipal();

	}


	public static void inscription() {
		String mail = saisieString("Saisir votre mail");
		String password = saisieString("Saisir votre password");
		String tel = saisieString("Saisir votre tel");
		String numero = saisieString("Saisir votre numero");
		String voie = saisieString("Saisir votre voie");
		String cp = saisieString("Saisir votre cp");
		String ville = saisieString("Saisir votre ville");

		Client c = new Client(mail,password,tel,numero,voie,cp,ville);
		daoCompte.insert(c);

	}



	public static void seConnecter() {
		String mail = saisieString("Saisir votre mail");
		String password = saisieString("Saisir votre password");
		connected=daoCompte.seConnecter(mail,password);
		Context.getSingleton().setConnected(connected);
		
		if(connected instanceof Client) {menuClient();}

		else if(connected instanceof Staff) {menuStaff();}

		else {System.out.println("Identifiants invalides");}

	}

	public static void menuStaff() {
		System.out.println("Menu Staff : ");
		System.out.println("1 - Gestion des Animaux");
		System.out.println("2 - Gestion des Activités");
		System.out.println("3 - Gestion des Vehicules");
		System.out.println("4 - Gestion des Reservations");
		System.out.println("5 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : gestionAnimaux();break;
		case 2 : gestionActivites();break;
		case 3 : gestionVehicules();break;
		case 4 : gestionReservations();break;
		case 5 : connected=null;menuPrincipal();break;
		}

		menuStaff();
	}

	public static void gestionReservations() {
		System.out.println("A FAIRE PAR JORDAN");
		/*
		System.out.println("Gestion des Reservations : ");
		System.out.println("1 - Lister les reservations");
		System.out.println("2 - Modifier une reservation");
		System.out.println("3 - Supprimer un reservation");
		System.out.println("4 - Retour");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : break;
		case 2 : break;
		case 3 : break;
		case 4 : break;
		}
		gestionReservations();
		 */
	}

	public static void gestionVehicules() {
		System.out.println("Gestion des vehicules : ");
		System.out.println("1 - Lister les vehicules");
		System.out.println("2 - Modifier un vehicule");
		System.out.println("3 - Supprimer un vehicule");
		System.out.println("4 - Ajouter un vehicule");
		System.out.println("5 - Retour");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : showVehicules();break;
		case 2 : modiferVehicules();break;
		case 3 : supprimerVehicule();break;
		case 4 : ajouterVehicule();break;
		case 5 : menuStaff();break;
		}
		gestionVehicules();
	}

	public static void ajouterVehicule() {
		String modele = saisieString("Saisir le modele");
		Vehicule v = new Vehicule(modele);
		daoVehicule.insert(v);



	}

	public static void supprimerVehicule() {
		showVehicules();
		int id = saisieInt("Saisir l'ID du modèle à supprimer'");
		daoVehicule.delete(id);
	}

	public static void modiferVehicules() {
		showVehicules();

		int id = saisieInt("Saisir l'ID du vehicule à modifier");
		Vehicule v = daoVehicule.findById(id);


		String model = saisieString("Saisir le modèle du véhicule");
		v.setModel(model);
		daoVehicule.update(v);
		
		

	}

	public static void showVehicules() {
		for(Vehicule v : daoVehicule.findAll()) 
		{
			System.out.println(v);
		}

	}

	public static void gestionActivites() {
		System.out.println("Gestion des activites : ");
		System.out.println("1 - Lister les activites");
		System.out.println("2 - Modifier une activite");
		System.out.println("3 - Supprimer une activite");
		System.out.println("4 - Ajouter une activite");	
		System.out.println("5 - Retour");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : showActivites();break;
		case 2 : modifierActivite();break;
		case 3 : supprimerActivite();break;
		case 4 : ajouterActivite();break;
		case 5 : menuStaff();break;
		}
		gestionActivites();
	}

	public static void ajouterActivite() {
		Activite a;

		System.out.println("Quelle activité ajouter ?");
		System.out.println("1 - Safari");
		System.out.println("2 - Aquatique");
		System.out.println("3 - Retour");

		int choix = saisieInt("Choix numéro activité");

		if (choix == 1){
			Meteo m = Meteo.valueOf(saisieString("Entrer meteo"));
			LocalDate date = LocalDate.parse(saisieString("Entrer date"));
			LocalTime time = LocalTime.parse(saisieString("Entre heure"));
			double prix = saisieDouble("Entrer prix");
			a = new Safari(m, date, time, prix, null, null);
			daoActivite.insert(a);
		}

		else if (choix == 2) {
			Meteo m = Meteo.valueOf(saisieString("Entrer meteo"));
			LocalDate date = LocalDate.parse(saisieString("Entrer Date"));
			LocalTime time = LocalTime.parse(saisieString("Entrer heure"));
			double prix = saisieDouble("Entrer prix");

			a = new Aquatique(m, date, time, prix);
			daoActivite.insert(a);
		} else {
			gestionActivites();
		}

	}

	public static void supprimerActivite() {
		showActivites();
		int id = saisieInt("veuillez saisir l'id de l'activité à supprimer: ");
		daoActivite.delete(id);

	}

	public static void modifierActivite() {
		showActivites();
		int choix = saisieInt("Saisir l'id de l'activité à modifier :");
		Activite a = daoActivite.findById(choix);

		String dateActivite = saisieString("Nouvelle  date de l'activite' ?");
		String heureActivite = saisieString("Nouvelle heure de l'activite' ?");
		double prixActivite = saisieDouble("saisir le prix voulu");
		String meteoActivite = saisieString("saisir la meteo voulue");
		a.setDate(LocalDate.parse(dateActivite));
		a.setHeure(LocalTime.parse(heureActivite));
		a.setPrix(prixActivite);
		a.setMeteo(Meteo.valueOf(meteoActivite));
		daoActivite.update(a);


	}

	public static void showActivites() {
		for(Activite a : daoActivite.findAllDisponibles()) 
		{
			System.out.println(a);
		}
	}

	public static void gestionAnimaux() {
		System.out.println("Gestion des animaux : ");
		System.out.println("1 - Lister les animaux");
		System.out.println("2 - Modifier un animal");
		System.out.println("3 - Supprimer un animal");
		System.out.println("4 - Ajouter un animal");	
		System.out.println("5 - Retour");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : showAnimaux();break;
		case 2 : modifierAnimal();break;
		case 3 : supprimerAnimal();break;
		case 4 : ajouterAnimal();break;
		case 5 : menuStaff();break;
		}
		gestionAnimaux();
	}

	public static void ajouterAnimal() {
		System.out.println("1 pour l'Ecureuil \n2 pour le Serpent \n3 pour le Sanglier");
		int choix=saisieInt("choisir le type d'animal");
		switch(choix)
		{
		case 1:
		{
			String nom=saisieString("Entrer le nom de l'écureuil");
			Ecureuil c=new Ecureuil(nom);
			daoAnimal.insert(c);break;
		}
		case 2:
		{
			String nom=saisieString("Entrer le nom du serpent");
			Serpent c=new Serpent(nom);
			daoAnimal.insert(c);break;
		}
		case 3:
		{
			String nom=saisieString("Entrer le nom du sanglier");
			Sanglier c=new Sanglier(nom);
			daoAnimal.insert(c);break;
		}
		}
	}
	public static void supprimerAnimal() {
		showAnimaux();
		int dead = saisieInt("Quel animal voulez-vous supprimer ?");
		daoAnimal.delete(dead);
	}

	public static void modifierAnimal() {
		showAnimaux();
		int choix = saisieInt("Quel est l'id de l'animal à modifier ? ");

		Animal a=null;
		String nom = saisieString("Quel est le nom de l'animal ? ");
		String type = saisieString("TRANSFORMATION ! En quel animal (Ecureuil,Serpent,Sanglier) ? ");
		switch(type) 
		{
		case "Ecureuil": a= new Ecureuil(choix,nom);break;
		case "Serpent": a= new Serpent(choix,nom);break;
		case "Sanglier": a = new Sanglier(choix,nom);break;
		}

		daoAnimal.update(a);
	}
	public static void showAnimaux() {
		for(Animal a : daoAnimal.findAll()) 
		{
			System.out.println(a);
		}

	}

	public static void menuClient() {
		System.out.println("Menu Client : ");
		System.out.println("1 - Lister les actvites");
		System.out.println("2 - Faire une reservation");
		System.out.println("3 - Voir mes reservations");
		System.out.println("4 - Modifier mon compte");
		System.out.println("5 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : showActivites();break;
		case 2 : faireReservation();break;
		case 3 : showReservationsClient();break;
		case 4 : modifierCompte();break;
		case 5 : connected=null;menuPrincipal();break;
		}

		menuClient();
	}

	public static void modifierCompte() {
		String mail = saisieString("Saisir votre nouveau mail");
		String password = saisieString("Saisir votre nouveau password");

		connected.setMail(mail);
		connected.setPassword(password);

		daoCompte.update(connected);
	}

	public static void showReservationsClient() {

		for(Reservation r : daoReservation.findAllReservationClient(connected.getNumero())) 
		{
			System.out.println(r);
		}    
	}

	public static void faireReservation() {
		showActivites();
		int id_activite = saisieInt("Saisir l'id de l'activité choisie");
		Activite a = daoActivite.findById(id_activite);


		String prenom = saisieString("Saisir votre prénom");
		String nom = saisieString("Saisir votre nom");
		int age = saisieInt("Saisir votre age");

		Participant p = new Participant(nom, prenom, age);

		p=daoParticipant.insert(p);

		Reservation r = new Reservation(a, (Client) connected, p);

		daoReservation.insert(r);

	}
	public static void main(String[] args) {


		menuPrincipal();

	}
}
