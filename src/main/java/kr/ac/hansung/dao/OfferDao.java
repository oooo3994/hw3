package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
//@Component("offerDao")
public class OfferDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	public List<Offer> getOffer(String year, String semester) {

		String sqlStatement = "select * from offers where year="+year+" and semester="+semester;
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setS_name(rs.getString("s_name"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setS_type(rs.getString("s_type"));
				offer.setProfessor(rs.getString("professor"));
				offer.setGrades(rs.getInt("grades"));

				return offer;

			}

		});

	}

	// query and return multiple objects

	public List<Offer> getOffers() {

		String sqlStatement = "select year, semester, sum(grades) from offers group by semester, year order by year, semester;";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setGrades(rs.getInt("sum(grades)"));

				return offer;

			}

		});

	}

	
	public boolean insert(Offer offer) {
		String s_name = offer.getS_name();
		int year = offer.getYear();
		int semester = offer.getSemester();
		String s_type = offer.getS_type();
		String professor = offer.getProfessor();
		int grades = offer.getGrades();

		String sqlStatement = "insert into offers(s_name, year, semester, s_type, professor, grades) values (?,?,?,?,?,?)";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { s_name, year, semester, s_type, professor, grades }) == 1);
	}

}
