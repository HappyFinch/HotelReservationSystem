package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

    private ReservationService(){} // singleton pattern (单例模式) ：私有构造函数，不允许外部创建实例
    private static ReservationService reservationServiceInstance = new ReservationService(); // singleton pattern (单例模式)  只提供一个实例 
    public static ReservationService getInstance(){ // singleton pattern (单例模式) 只提供一个实例
        return reservationServiceInstance;
    }

    private Collection<Reservation> reservations = new HashSet<>();
    private Collection<IRoom> rooms = new HashSet<>();

    public void addRoom(IRoom room){
        rooms.add(room);
    }

    public IRoom getARoom(String roomId){ // 通过房间号获取房间
        for(IRoom room : rooms){
            if(room.getRoomNumber().equals(roomId)){
                return room;
            }
        }
        return null;
    }

    public Collection<IRoom> getAllRooms(){
        return rooms;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> availableRooms = new ArrayList<>();
        for(IRoom room : rooms){
            boolean isAvailable = true;
            for(Reservation reservation : reservations){
                if(reservation.getRoom().equals(room)){
                    if(!(checkInDate.after(reservation.getCheckOutDate()) && checkOutDate.before(reservation.getCheckInDate()))){
                        isAvailable = false;
                        break;
                    }
                }
            }
            if(isAvailable){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> customerReservations = new ArrayList<>();
        for(Reservation reservation : reservations){
            if(reservation.getCustomer().equals(customer)){
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }

    public void printAllReservation(){
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet.");
            return;
        }else{
            for(Reservation reservation : reservations){
                System.out.println(reservation);
            }
        }
    }
    

}
