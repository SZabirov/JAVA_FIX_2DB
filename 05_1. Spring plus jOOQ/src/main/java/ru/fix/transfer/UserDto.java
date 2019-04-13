package ru.fix.transfer;

import ru.fix.models.tables.records.ShopUserRecord;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Integer id;
    private String username;

    public UserDto() {
    }

    public UserDto(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static List<UserDto> from(List<ShopUserRecord> shopUserRecords) {
        return shopUserRecords
                .stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }

    public static UserDto from(ShopUserRecord shopUserRecord) {
        return new UserDto(shopUserRecord.getId(),
                shopUserRecord.getUsername());
    }
}
