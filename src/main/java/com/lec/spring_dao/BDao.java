package com.lec.spring_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import com.lec.spring_model.Customer;
import com.lec.spring_model.Order;
import com.lec.spring_model.Product; 

public class BDao {

	private Connection connect = null;
	private Statement statement = null; 
	private ResultSet resultSet = null;

	DataSource dataSource;
	public BDao() {
		try { 

			String url = "jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //"jdbc:mysql://localhost:3306/mydatabase";
			String user = "root";
			String pass = "Root@123";
			Class.forName ("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection (url, user, pass);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	public ArrayList<Customer> getCustomers() {

		ArrayList<Customer> dtos = new ArrayList<Customer>();

		try { 
			String query = "select *  from user";
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("userId")); 
				String name = resultSet.getString("UserName"); 
				String password = resultSet.getString("Password");
				Customer customer = new Customer();
				customer.setcId(id);
				customer.setcName(name);
				customer.setcPassword(password);
				dtos.add(customer); 
			}

		}catch(Exception e) {
			e.printStackTrace();
		}  
		return dtos;
	}

	public void saveCustomer(Customer customer) {

		try { 
			String sql = "INSERT INTO user (UserName,Password) values (?, ?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, customer.getcName());
			statement.setString(2, customer.getcPassword());
			int row = statement.executeUpdate(); 
		}catch (SQLException ex) { 
			ex.printStackTrace();
		}    
	}

	public void updateCustomer(Customer customer) {
		try { 
			int id = Integer.parseInt(customer.getcId()+"");
			String query = "update user set UserName = ?, Password = ? where userId = "+ id;
			PreparedStatement statement = connect.prepareStatement(query); 
			statement.setString(1, customer.getcName());
			statement.setString(2, customer.getcPassword());
			System.out.println();
			int row = statement.executeUpdate(); 
		}catch (SQLException ex) { 
			ex.printStackTrace(); 
		}
	}

	public ArrayList<Order> getOrders() {
		// TODO Auto-generated method stub
		ArrayList<Order> dtos = new ArrayList<Order>();

		try { 
			String query = "select *  from Orders";
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("OrderID")); 
				int qty = Integer.parseInt((resultSet.getString("QTY"))); 
				String date = resultSet.getString("orderDate"); 
				int userId = Integer.parseInt(resultSet.getString("userID"));
				int productId = Integer.parseInt(resultSet.getString("ProductID"));
				Order order = new Order();
				order.setoId(id);
				order.setQty(qty);
				order.setOrderDate(date);
				System.out.println("QQQTTTTYYYYY in STOCK  11111111111111333333"+ userId);
				String query1 = "select * from user where userId = "+ userId ; 
				Statement statement1 = connect.createStatement();
				ResultSet resultSet1 = statement1.executeQuery(query1);  
				while(resultSet1.next()) {
					String name = resultSet1.getString("UserName"); 
					String password = resultSet1.getString("Password");
					Customer customer = new Customer();
					customer.setcId(userId);
					customer.setcName(name);
					customer.setcPassword(password);
					order.setCust(customer); 
				}
				query = "select * from Product where ProductID = "+ productId ;
				Statement statement2 = connect.createStatement();
				ResultSet resultSet2 = statement2.executeQuery(query);
				while(resultSet2.next()) {
					int P_id = Integer.parseInt(resultSet2.getString("ProductID")); 
					String pDesc = resultSet2.getString("pDesc"); 
					int qtyInStock = Integer.parseInt(resultSet2.getString("qtyInStock"));
					System.out.println(qtyInStock+"QQQTTTTYYYYY in STOCK 22222222222222 333333"+pDesc);
					Product product = new Product();
					product.setpId(P_id); 
					product.setpDesc(pDesc);
					product.setQtyInStock(qtyInStock);
					System.out.println("QQQTTTTYYYYY in STOCK  333333");
					order.setProd(product);
				}
				dtos.add(order); 
			}


		}catch(Exception e) {
			e.printStackTrace();
		}  
		return dtos; 
	}

	public void saveOrder(Order o) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
	    System.out.println(date);
		try { 
			String sql = "INSERT INTO Orders (QTY,orderDate, userID,ProductID) values (?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql); 
			statement.setInt(1,Integer.parseInt(o.getQty()+""));
			statement.setDate(2, date);
			statement.setInt(3, Integer.parseInt(o.getCust().getcId()+""));
			statement.setInt(4, Integer.parseInt(o.getProd().getpId()+""));
			statement.executeUpdate(); 
		}catch (SQLException ex) { 
			ex.printStackTrace();
		} 
	}

	public ArrayList<Product> getProducts() {
		// TODO Auto-generated method stub
		ArrayList<Product> dtos = new ArrayList<Product>();

		try { 
			String query = "select *  from Product";
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				int P_id = Integer.parseInt(resultSet.getString("ProductID")); 
				String pDesc = resultSet.getString("pDesc"); 
				int qtyInStock = Integer.parseInt(resultSet.getString("qtyInStock")); 
				Product product = new Product();
				product.setpId(P_id); 
				product.setpDesc(pDesc);
				product.setQtyInStock(qtyInStock);
				dtos.add(product); 
			}

		}catch(Exception e) {
			e.printStackTrace();
		} 
		return dtos; 
	}

	public void saveProduct(Product p) {
		// TODO Auto-generated method stub
		try { 
			String sql = "INSERT INTO Product (ProductID, pDesc,qtyInStock) values (?,?, ?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			System.out.println(Integer.parseInt(p.getpId()+"")+"   inserttttttttttttiiiingggggg PPPPPPRRRRROOOODDDDDDUUUCCCT");
			statement.setInt(1,Integer.parseInt(p.getpId()+""));
			statement.setString(2, p.getpDesc());
			statement.setInt(3, p.getQtyInStock());
			statement.executeUpdate(); 
		}catch (SQLException ex) { 
			ex.printStackTrace();
		}  

	}



}
