package christmas.core.controller;

import christmas.core.domain.Menu;
import christmas.core.service.ReserveService;
import christmas.ui.input.InputView;
import christmas.ui.output.OutputView;
import christmas.util.Parser;

import java.time.LocalDate;
import java.util.HashMap;

public class ReserveController {
    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    public void run() {
        hello();

        reserve();

        showReservationDetails();
    }

    private void hello() {
        OutputView.printHello();
    }

    private void reserve() {
        LocalDate date = readValidDate();
        HashMap<Menu, Integer> menus = readValidMenus();

        try {
            reserveService.reserve(date, menus);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            reserve();
        }
    }

    private LocalDate readValidDate() {
        try {
            return Parser.parseDateInput(InputView.readDate());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            return readValidDate();
        }
    }

    private HashMap<Menu, Integer> readValidMenus() {
        try {
            return Parser.parseMenuInput(InputView.readMenus());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            return readValidMenus();
        }
    }

    private void showReservationDetails() {
        // reserveService.showReservation();
    }
}
