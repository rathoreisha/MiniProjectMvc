package com.Isha.ContactInfo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Isha.ContactInfo.Model.Contactinfo;

@Repository
public interface ContactRepo extends JpaRepository<Contactinfo, Integer>{

}
