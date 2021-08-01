package com.ms3.contactapi.common.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class PaginatedItem<T> {

    private static final PaginatedItem EMPTY = new PaginatedItem<>(Collections.emptyList(), 0 , 0L);

    private final List<T> items;
    private final long totalPages;
    private final long totalItems;

    @SuppressWarnings("unchecked")
    public static <T> PaginatedItem<T> empty() {
        return (PaginatedItem<T>) EMPTY;
    }

    public <U> PaginatedItem<U> map(Function<? super T, ? extends U> converter) {
        List<U> convertedItems = items.stream()
                .map(converter)
                .collect(Collectors.toList());
        return new PaginatedItem<>(convertedItems, totalPages, totalItems);
    }
}
