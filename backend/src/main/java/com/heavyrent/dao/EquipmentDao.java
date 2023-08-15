package com.heavyrent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavyrent.pojo.Equipment;

public interface EquipmentDao extends JpaRepository<Equipment, Long> {

}
