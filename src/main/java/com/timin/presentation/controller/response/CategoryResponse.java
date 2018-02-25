package com.timin.presentation.controller.response;

import java.util.List;

public interface CategoryResponse {
    String getName();

    List<? extends CardResponse> getCards();
}
