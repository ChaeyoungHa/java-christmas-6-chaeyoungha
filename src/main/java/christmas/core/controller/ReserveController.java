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
        try {
            LocalDate date = Parser.parseDateInput(InputView.readDate());
            HashMap<Menu, Integer> menus = Parser.parseMenuInput(InputView.readMenus());

            // reserveService.reserve(date, menus);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            reserve();
        }
    }

    private void showReservationDetails() {
        // reserveService.showReservation();
    }
}
