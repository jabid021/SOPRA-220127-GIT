package centerpark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import centerpark.exception.ClientException;
import centerpark.model.Client;
import centerpark.repositories.ClientRepository;
import centerpark.repositories.ReservationRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	public void create(Client c) {
		if (c.getNumero() != null) {
			throw new ClientException("le numero ne doit pas etre defini");
		}
		if (c.getMail() == null || c.getMail().isEmpty()) {
			throw new ClientException("le mail doit etre defini");
		}
		clientRepository.save(c);
	}

	public void update(Client c) {
		if (c.getNumero() == null) {
			throw new ClientException("le numero doit etre defini");
		}
		if (c.getMail() == null || c.getMail().isEmpty()) {
			throw new ClientException("le mail doit etre defini");
		}
		Client clientEnBase = getByNumero(c.getNumero());
		clientEnBase.setAdresse(c.getAdresse());
		clientEnBase.setMail(c.getMail());
		clientEnBase.setTel(c.getTel());
		clientRepository.save(clientEnBase);
	}

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client getByNumero(Integer numero) {
		return clientRepository.findById(numero).orElseThrow(() -> {
			throw new ClientException("numero inconnu");
		});
	}

	public Client getByNumeroWithReservation(Integer numero) {
		return clientRepository.findByNumeroWithReservations(numero).orElseThrow(() -> {
			throw new ClientException("numero inconnu");
		});
	}

	public void delete(Client c) {

		Client clientEnBase = getByNumero(c.getNumero());
		reservationRepository.deleteByClient(clientEnBase);
		clientRepository.delete(clientEnBase);
	}

	public void deleteByNumero(Integer numero) {
		Client client = new Client();
		client.setNumero(numero);
		delete(client);
	}

}
