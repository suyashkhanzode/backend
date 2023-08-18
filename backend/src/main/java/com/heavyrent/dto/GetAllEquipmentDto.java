package com.heavyrent.dto;

import java.util.List;

import com.heavyrent.pojo.Equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEquipmentDto {

	private List<Equipment> list;
}
