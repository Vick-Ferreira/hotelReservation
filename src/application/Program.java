package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		// ENTRADA DE DADOS- ONDE USUARIO COLOCA-RA OS DADOS
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); // next recebe uma string e converte com o SimpleDateFormat para date

		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		// DATE tem um metodo chamado after, que testa se a data é depois da outra
		if (!checkOut.after(checkIn)) {
			// quer dizer que a data de sair é menor que a data de entrada
			System.out.print("Error in reservation: Check-out date must be after check-in date");
		} else {
			// instânciar o OBJETO RESERVATION
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // next recebe uma string e converte com o SimpleDateFormat para date
			// variaveis já estão declaradas em cima, reaproveitando variavel da novas datas
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			// ATENÇÃO APARTIR DAQUI É ATUALIZAÇÃO, vindo da subclass
			// teremos um retorno da classe reservation da qual instânciamos, de uma String,
			// por isso criei a variavel error para receber essa string

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {// deu erro
				System.out.println("Erro in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}

			sc.close();

		}

	}
}
