package com.example.workshop.controller;
import com.example.workshop.Exceptions.ErrorMessage;
import com.example.workshop.Output.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.*;

@RestController
public class WorldController {
    @GetMapping("/{code}")
    public ResponseEntity<Object> test(@PathVariable String code){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:8080/world-db", "world", "world123");
            PreparedStatement selectStatement = conn.prepareStatement("SELECT country.name, country.continent, country.population, country.life_expectancy, country_language.language FROM country INNER JOIN country_language ON country_language.country_code=country.code where country.code=?;");
            selectStatement.setString(1, code);
            ResultSet rs = selectStatement.executeQuery();
            Result result = null;
            //Invalid country code
            if (rs.next() == false) {
                ErrorMessage message = new ErrorMessage("INVALID_COUNTRY_CODE");
                return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            //Valid country code
            //Get only first row
            result = new Result(rs.getString("name"), rs.getString("continent"), rs.getInt("population"), rs.getDouble("life_expectancy"), rs.getString("language"));
            //Close connection & result set
            rs.close();
            conn.close();
            return new ResponseEntity<Object>(result, HttpStatus.OK);
        } catch (Exception e) {
            ErrorMessage message = new ErrorMessage("INTERNAL_ERROR");
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
