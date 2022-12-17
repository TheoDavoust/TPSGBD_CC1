package model;

public class Telephone {
	
	private int idTelephone;
	private Client client;
	private String telephone;
	
	public Telephone(int idTelephone, Client client, String telephone) {
		super();
		this.idTelephone = idTelephone;
		this.client = client;
		this.telephone = telephone;
	}

	public int getIdTelephone() {
		return idTelephone;
	}

	public Client getClient() {
		return client;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setIdTelephone(int idTelephone) {
		this.idTelephone = idTelephone;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "n°0" + telephone;
	}
}
