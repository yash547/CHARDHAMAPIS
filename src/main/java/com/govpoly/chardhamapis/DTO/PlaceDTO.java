package com.govpoly.chardhamapis.DTO;

import lombok.Data;

@Data
public class PlaceDTO {

    private int id;

    private String name;

    private String description;

    private String lat;

    private String longitute;

    private String images;
}
