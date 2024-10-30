package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// ENTRADA DE DADOS- ONDE USUARIO COLOCA-RA OS DADOS
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); // next recebe uma string e converte com o SimpleDateFormat para date
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

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
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}catch (ParseException e) {// TRATAR EXCEÇÃO
			System.out.println("Invalid date format");
		}catch (DomainException e) {//personalizada
			System.out.println("Erro in reservation: " + e.getMessage()); // e.getMessage pega mensagem de erro da exceção especifica quando cair dentro  desse bloco}
		}catch (RuntimeException e) { //ERRO GERAIS
			System.out.println("Unexpected error");
		}
			sc.close();
	}

}
