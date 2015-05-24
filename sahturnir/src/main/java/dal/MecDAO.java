package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import klase.Klub;
import klase.Mec;
import klase.Takmicar;

import org.apache.log4j.Logger;

public class MecDAO extends GenericDAO {
	
	public List<Mec> getMatchList(Long id) {
		List<Mec> mecevi = new ArrayList<Mec>();
		// MEHO UPIT MI DAJ
		return mecevi;
	}	
}
