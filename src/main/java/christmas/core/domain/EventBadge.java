package christmas.core.domain;

import java.util.Arrays;
import java.util.Objects;

public enum EventBadge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NONE("없음", 0);

    private final String name;
    private final int condition;

    EventBadge(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public static EventBadge of(String name) {
        return Arrays.stream(EventBadge.values())
                .filter(menu -> Objects.equals(menu.name, name))
                .findFirst()
                .orElse(NONE);
    }
}
