//package com.fis.proiectFis.service;
//import com.fis.proiectFis.entities.Flight;
//import com.fis.proiectFis.entities.Reservation;
//import com.fis.proiectFis.entities.Rezervare;
//import com.fis.proiectFis.entities.Zbor;
//import com.fis.proiectFis.repositories.ZborRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FlightReservationService {
//
//    @Autowired
//    private ZborRepo flightRepository;
//
//    public List<FlightDetails> searchFlights(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate returnDate, int adults, int children, int seniors, String flightClass, String tripType) {
//        // Validarea datelor de intrare
//        if (!validateInputs(departureCity, arrivalCity, departureDate, returnDate, tripType)) {
//            System.out.println("Datele de intrare nu sunt valide.");
//            return new ArrayList<>();
//        }
//
//        List<Zbor> foundFlights = flightRepository.findZborsByOrasdus(departureCity, arrivalCity);
//        List<FlightDetails> flightDetailsList = new ArrayList<>();
//
//        if (foundFlights.isEmpty()) {
//            System.out.println("Ne pare rău, nu s-au găsit zboruri pentru această rută. Vă rugăm să încercați o altă căutare.");
//            return flightDetailsList;
//        }
//
//        for (Zbor flight : foundFlights) {
//            if (isAvailable(flight, departureDate, returnDate, adults + children + seniors)) {
//
//
//                FlightDetails flightDetails = new FlightDetails();
//                flightDetails.setFlightCode(flight.getCod_zbor());
////                flightDetails.setAirline(flight.getAirline().getName()); // Assuming Airline has a 'name' property
//                flightDetails.setDepartureTime(flight.getSchedule().getDepartureTime());
//                flightDetails.setArrivalTime(flight.getSchedule().getArrivalTime());
//
//
//                flightDetailsList.add(flightDetails);
//            }
//        }
//
//        if (flightDetailsList.isEmpty()) {
//            System.out.println("Ne pare rău, nu s-au găsit zboruri convenabile. Vă rugăm să încercați o altă căutare.");
//        }
//
//        return flightDetailsList;
//    }
//
//    private boolean validateInputs(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate returnDate, String tripType) {
//        if (departureCity == null || arrivalCity == null || departureDate == null || tripType == null) {
//            return false;
//        }
//        if (tripType.equalsIgnoreCase("dus-intors") && returnDate == null) {
//            return false;
//        }
//        return true;
//    }
//
//    private boolean isAvailable(Zbor flight, LocalDate departureDate, LocalDate returnDate, int totalPassengers) {
//        // Check availability for departure date
//        if (!checkAvailabilityForDate(flight, departureDate, totalPassengers)) {
//            return false;
//        }
//
//        // Check availability for return date if the trip is round-trip
//        if (returnDate != null && !checkAvailabilityForDate(flight, returnDate, totalPassengers)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    private boolean checkAvailabilityForDate(Zbor flight, LocalDate date1, int totalPassengers) {
//        // Retrieve reservations for the specified flight and date
//        List<Rezervare> reservations = flight.getReservationsForDate(date1);
//        int reservedSeats = reservations.stream().mapToInt(Reservation::getNumberofPassengers).sum();
//
//        // Check if there are enough available seats
//        return (flight.getTotalSeats() - reservedSeats) >= totalPassengers;
//    }
//
//
//
//    public static class FlightDetails {
//        private String flightCode;
//        private String airline;
//        private LocalDateTime departureTime;
//        private LocalDateTime arrivalTime;
//        private double price;
//
//        // Getters and setters
//        public String getFlightCode() {
//            return flightCode;
//        }
//
//        public void setFlightCode(String flightCode) {
//            this.flightCode = flightCode;
//        }
//
//        public String getAirline() {
//            return airline;
//        }
//
//        public void setAirline(String airline) {
//            this.airline = airline;
//        }
//
//        public LocalDateTime getDepartureTime() {
//            return departureTime;
//        }
//
//        public void setDepartureTime(LocalDateTime departureTime) {
//            this.departureTime = departureTime;
//        }
//
//        public LocalDateTime getArrivalTime() {
//            return arrivalTime;
//        }
//
//        public void setArrivalTime(LocalDateTime arrivalTime) {
//            this.arrivalTime = arrivalTime;
//        }
//
//        public double getPrice() {
//            return price;
//        }
//
//        public void setPrice(double price) {
//            this.price = price;
//        }
//    }
//
