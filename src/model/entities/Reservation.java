package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation { // OBJETO RESERVATION

	// objeto com seus atributos e seus tipos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	// declarar para usar e imprimer dados com o uso da marcara com formatação correta
	// STATIC: para que NÃO seja instânciada um novo simpleDateFormat para cada
	// OBJETO RESERVATION que a aplicação tiver, APENAS UM
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// criando contrutore, criando argumento com seus tipos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {// propagando exceção se fosse runTimeException poderia retir o throws
		if (!checkOut.after(checkIn)) { // e se a data de cheout NAO for posterior da data de checkIn também não pode.
			throw new DomainException("Check-out date must be after check-in date");
			/* programação defencisa
			tratando já no inicio para que seja verificado que o cheout seja posterior ao
			checkin*/
		}
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates must be future dates of the current date"); // usando classe de exceção																							
			// NO CHEKOUT A DATA NÃO PODE SER ANTERIOR A DATA DO CHECKIN
		}
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

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {/* throws DomainException = permite que
																					 meu metodo updateDates PODE
																					lançar uma exceção*/ 

		Date now = new Date();
		// 1º VERIFICANDO O ERRO
		// NO CHEKIN A DATA NAO PODE SER ANTERIOR a data atual
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates"); // usando classe de exceção																							
			// NO CHEKOUT A DATA NÃO PODE SER ANTERIOR A DATA DO CHECKIN
		} // if lança a exceção
		if (!checkOut.after(checkIn)) { // e se a data de cheout NAO for posterior da data de checkIn também não pode.
			throw new DomainException("Check-out date must be after check-in date");
		}
		// ATUALIZA APOS 1º VERICAÇÃO
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Rom " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
