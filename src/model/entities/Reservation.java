package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation { // OBJETO RESERVATION

	// objeto com seus atributos e seus tipos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	// declarar para usar e imprimer dados com o uso da marcara com formatação
	// correta
	// STATIC: para que NÃO seja instânciada um novo simpleDateFormat para cada
	// OBJETO RESERVATION que a aplicação tiver, APENAS UM
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// criando contrutore, criando argumento com seus tipos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;// checkIn do OBEJETO recebe o que veio no argumento
		this.checkOut = checkOut;
	}

	// criando gets e sets para nossos atributos

	// GET: tipo e retorno do atributo
	public Integer getRoomNumber() {
		return roomNumber;
	}

	// SET: vazio, passa tipo e atributo como ARGUMENTO e interliga o argumento com
	// o uso do this ao atributo
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// criando metodo da duração em dias; tipo Long retorna um valor mais longo
	public long duration() {
		// diferença entre as duas datas em milisegundos

		// retorna a quantidade em miliseguntos da data
		long diff = checkOut.getTime() - checkIn.getTime();

		// classe TimeUnit faz conversão de milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	// retornada VAZIO (void), agora vai retornar uma STRING
	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();

		// 1º VERIFICANDO O ERRO

		// NO CHEKIN A DATA NAO PODE SER ANTERIOR a data atual
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates"; // return corta o metodo e retorna uma string
			// NO CHEKOUT A DATA NÃO PODE SER ANTERIOR A DATA DO CHECKIN
		}
		if (!checkOut.after(checkIn)) { // e se a data de cheout NAO for posterior da data de checkIn também não pode
										// ser atualizada
			return "Check-out date must be after check-in date";
		}
		//ATUALIZA APO 1º VERICAÇÃO
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; //RETORNA SE NÃO TIVER ERROS!! LOGO É O RETORNO DA STRING SE DER CERTO
	}

	@Override
	public String toString() {
		return "Rom " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

	/*
	 * DATAS NÃO VÃO MUDAR ARBITRARIAMENTE / SET ATUALIZA
	 * 
	 * public void setCheckIn(Date checkIn) { this.checkIn = checkIn; }
	 * 
	 * public void setCheckOut(Date checkOut) { this.checkOut = checkOut; }
	 */

}
