package christmas.core.controller;

import christmas.core.service.ReserveService;
import christmas.ui.input.InputValidator;
import christmas.ui.input.InputView;
import christmas.ui.output.OutputView;

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
            String date = readValidDate();
            String menus = readValidMenus();

            // reserveService.reserve(date, menus);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());

            reserve();
        }
    }

    private String readValidDate() {
        String dateInput;

        do {
            dateInput = InputView.readDate();
        } while (!InputValidator.isValidDateInput(dateInput));

        return dateInput;
    }

    private String readValidMenus() {
        String menuInput;

        do {
            menuInput = InputView.readMenus();
        } while (!InputValidator.isValidMenuInput(menuInput));

        return menuInput;
    }

    private void showReservationDetails() {
        // reserveService.showReservation();
    }
}
