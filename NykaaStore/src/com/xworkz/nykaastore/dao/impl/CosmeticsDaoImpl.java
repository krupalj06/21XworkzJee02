package com.xworkz.nykaastore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xworkz.nykaastore.dao.CosmeticsDao;
import com.xworkz.nykaastore.dto.Cosmetics;

public class CosmeticsDaoImpl implements CosmeticsDao {

	@Override
	public Connection getDBConnection() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/nykaa";
		String username = "root";
		String password = "root123";
		Connection conn = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);

			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		throw new SQLException(); // Custom exception

	}

	@Override
	public boolean save(Cosmetics cosmetics) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getDBConnection();
			System.out.println(conn);

			stmt = conn.createStatement(); // provides Enviroment
			int id = cosmetics.getCosmeticsId(); // 5;
			String name = cosmetics.getName(); // "Mascara";
			double price = cosmetics.getPrice(); // 500.00;
			int qnt = cosmetics.getQuantity(); // 2;
			String brand = cosmetics.getBrand(); // "sugar";

			String sqlQuery = "insert into cosmetics values(" + id + ", '" + name + "', " + price + ", " + qnt + " , '"
					+ brand + "');";
			int result = stmt.executeUpdate(sqlQuery);

			if (result >= 1)
				return true;
			else
				return false;

		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Driver class was not found");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public ArrayList<Cosmetics> readAllRecords() {

		ArrayList<Cosmetics> cosList = new ArrayList<Cosmetics>();
		try {
			Connection conn = getDBConnection();

			Statement stmt = conn.createStatement();

			String sqlQuery = "select * from cosmetics; "; // 1 Primer 100 1 BBrown
			// select name , brand from Cosmetics;

			ResultSet result = stmt.executeQuery(sqlQuery);

			while (result.next()) {
				// get*** methods
				Cosmetics cosmetics = new Cosmetics();

				int cosmeticId = result.getInt("cosmeticsId");
				cosmetics.setCosmeticsId(cosmeticId);

				String name = result.getString(2);
				cosmetics.setName(name);

				double price = result.getDouble(3);
				cosmetics.setPrice(price);

				int quantity = result.getInt("quantity");
				cosmetics.setQuantity(quantity);

				String brand = result.getString("brand");
				cosmetics.setBrand(brand);

//				Cosmetics cosmetics2 = new Cosmetics(cosmeticId, name, price, quantity, brand);

				cosList.add(cosmetics);
			}

			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cosList;
	}

	@Override
	public boolean updateRecordBasedOnBrand(double newPriceValue, String brand) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "update cosmetics set price = " + newPriceValue + " where brand = '" + brand + "';";
			int rowsEffected = stmt.executeUpdate(sqlQuery);

			System.out.println("RowsEffected are: " + rowsEffected);
			if (rowsEffected >= 1)
				return true;
			else
				return false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean deleteRecordBasedonCosmeticId(int cosmeticId) {
		return false;
	}

}
