package com.psa.flight_reservation_app_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psa.flight_reservation_app_5.dto.ReservationRequest;
import com.psa.flight_reservation_app_5.entity.Reservation;
import com.psa.flight_reservation_app_5.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
		@RequestMapping("/completeReservation")
		public String completeReservation(ReservationRequest request, ModelMap modelMap) {
//			System.out.println(reservation.getFirstName());
//			System.out.println(reservation.getCardNumber());
			Reservation reservationId = reservationService.bookFlight(request);
			
			modelMap.addAttribute("reservationId", reservationId.getId());
			return "confirmReservation";
		}
}
