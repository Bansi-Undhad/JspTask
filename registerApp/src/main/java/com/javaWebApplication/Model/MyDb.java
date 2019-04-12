package com.javaWebApplication.Model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;

public class MyDb implements MyDbInterface {
	public Connection con;
	
	String fileName = "config.properties";
	public Connection genCon()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);
            
			Properties prop = new Properties();
			prop.load(input);
			
			String user = prop.getProperty("username");
            String pass = prop.getProperty("password");
            
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup", user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void writeData(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		String users="user";
		ResultSet rs = null;
		String numberofkey = null;
		PreparedStatement pstmt=null;
		PreparedStatement stmt = null;
		try {
			String sql1 = "insert into user(fname,lname,dob,email,password,gender,language,roll) values(?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getFname());
			stmt.setString(2, user.getLname());
			stmt.setString(3, user.getDob());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getGender());
			stmt.setString(7, user.getLang());
			stmt.setString(8, users);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				 numberofkey = rs.getString(1);
				System.out.println("Generated Emp Id: " + numberofkey);
			}
			
			for(Address add : user.getAddress())
			{
				try {
				String sql2 ="insert into address(a_id,addressLine1,addressLine2,city,state,pincode,id)values(?,?,?,?,?,?,?)";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql2);
				ps.setString(1, null);
				ps.setString(2, add.getAddressLine1());
				ps.setString(3, add.getAddressLine2());
				ps.setString(4, add.getCity());
				ps.setString(5, add.getState());
				ps.setString(6, add.getPincode());
				ps.setString(7,numberofkey);
				ps.executeUpdate();
				ps.close();
				}catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String sql = "insert into image (i_id,image,u_id) values (?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1, null);
            pstmt.setBlob(2, user.getImg());
            pstmt.setString(3, numberofkey);
            pstmt.executeUpdate();
           		
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (pstmt != null) {
	                pstmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	 if(stmt != null) {
		            	stmt.close();
		            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }
	}
	public String readData(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		PreparedStatement stmt=null;
		try {
			stmt = con.prepareStatement("select email,password,roll from user where email=? and password= ? ");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				String rollDb = rs.getString("roll");
				if(rollDb.equals("user")) {
					return "user";
				}
				else {
					return "admin";					
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        	
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }
		return "failure";
	}
	public  ArrayList<User>  retriveData()
	{
		ArrayList<User> dataList = new ArrayList<User>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		Statement stmt=null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from user");
			while(rs.next()) 
			{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setLang(rs.getString(8));
				dataList.add(user);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }
		return dataList;
	}
	@Override
	public ArrayList<User> retriveAdminImg() {
		// TODO Auto-generated method stub
		ArrayList<User> adminImg = new ArrayList<User>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		Statement stmt =null;
		try {
		    stmt = con.createStatement();
			rs = stmt.executeQuery("select * from image");
			while(rs.next()) 
			{
				User user = new User();
				user.setIId(rs.getInt(1));
				Blob blob = rs.getBlob(2);
				user.setId(rs.getInt(3));
				System.out.println("get imagee " +rs.getBlob(2));
				
				InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                 
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                user.setBase64Image(base64Image);
				adminImg.add(user);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }		
		return adminImg;
	}
	public ArrayList<Address> retriveAddress(){
		ArrayList<Address> addresslist = new ArrayList<Address>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from address");
			while(rs.next()) 
			{
				Address address = new Address();
				address.setAId(rs.getString(1));
				address.setAddressLine1(rs.getString(2));
				address.setAddressLine2(rs.getString(3));
				address.setCity(rs.getString(4));
				address.setState(rs.getString(5));
				address.setPincode(rs.getString(6));
				address.setId(rs.getString(7));
				addresslist.add(address);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }	
		return addresslist;
	}
//	public User fetch(int id)
//	{
//		MyDb db = new MyDb();
//		Connection con = db.genCon();
//		ResultSet rs = null;
//		User user = new User();
//		try {
//			 PreparedStatement stmt = con.prepareStatement("select * from user where id=?");
//			 stmt.setLong(1,id);
//			 rs = stmt.executeQuery();
//			while(rs.next()) 
//			{
//				user.setId(rs.getInt(1));
//				user.setFname(rs.getString(2));
//				user.setLname(rs.getString(3));
//				user.setDob(rs.getString(4));
//				user.setEmail(rs.getString(5));
//				user.setPassword(rs.getString(6));
//				user.setGender(rs.getString(7));
//				user.setLang(rs.getString(8));
//				}
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return user;
//	}
	@Override
	public User retriveImg(User user) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		Statement stmt = null;
		Blob blob = null;
        InputStream inputStream = null;
		User retriveImg = new User();
		try {
			stmt = con.createStatement();
            rs = stmt.executeQuery("select * from image where u_id='" + user.getId() + "'");
			while(rs.next()) 
			{
					retriveImg.setIId(rs.getInt(1));
					blob = rs.getBlob(2);
					System.out.println("get imagee " +rs.getBlob(2));
					
					inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                 
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                if(base64Image!=null) {
	                	retriveImg.setBase64Image(base64Image);			
	                }
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs!=null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	 if (stmt != null) {
		                stmt.close();
		            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }		
		return retriveImg;
	}
	public ArrayList<Address> fetchAddress(Address address){
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<Address> useraddress = new ArrayList<Address>();
		try {
			stmt = con.prepareStatement("select * from address where id=?");
			stmt.setString(1, address.getId());
            rs = stmt.executeQuery();
			while(rs.next()) 
			{
				Address address1 = new Address();
				address1.setAId(rs.getString(1));
				address1.setAddressLine1(rs.getString(2));
				address1.setAddressLine2(rs.getString(3));
				address1.setCity(rs.getString(4));
				address1.setState(rs.getString(5));
				address1.setPincode(rs.getString(6));
				address1.setId(rs.getString(7));
				useraddress.add(address1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }	
		return useraddress;
	}
	public User  getEmployeeById(int id) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		User user = new User();
		PreparedStatement stmt = null;
		try {
			 stmt = con.prepareStatement("select * from user where id=?");
			 stmt.setInt(1,id);
			 rs = stmt.executeQuery();
			while(rs.next()) 
			{
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setLang(rs.getString(8));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }	
		return user;
	}
	public void update(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		 PreparedStatement stmt = null;
		try {
			 stmt = con.prepareStatement("update user set fname=?,lname=?,dob=?,password=?,language=?,gender=? where id=?");
			 stmt.setString(1,user.getFname());
			 stmt.setString(2,user.getLname());
			 stmt.setString(3,user.getDob());
			 stmt.setString(4,user.getPassword());
			 stmt.setString(5,user.getLang());	 
			 stmt.setString(6,user.getGender());
			 stmt.setInt(7,user.getId());
			 stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }	
	}
	@Override
	public void updateImg(User user) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
		PreparedStatement stmt = null;
		try {
			 stmt = con.prepareStatement("update image set image=? where i_id=?");
			 stmt.setBlob(1, user.getImg());
			 stmt.setInt(2,user.getIId());
			 stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }	
	}
	public int delete(int id)
	{
		MyDb db = new MyDb();
		Connection con = db.genCon();
		int status=0;
		 PreparedStatement stmt = null;
		try {
			 stmt = con.prepareStatement("delete from user where id=?");
			 stmt.setInt(1,id);
			 status=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	 if (stmt != null) {
		                stmt.close();
		            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }		
		return status;
	}
	@Override
	public int id(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		int id=0;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select id from user where email= ? ");
			stmt.setString(1, user.getEmail());
			rs = stmt.executeQuery();
			while (rs.next()) {
			 id = rs.getInt("id");	
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	            
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }		
		return id;
	}
	@Override
	public ArrayList<Address> showAdd(User user) {
		// TODO Auto-generated method stub
		ArrayList<Address> showList = new ArrayList<Address>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from address where id='" + user.getId() + "'");
            while (rs.next()) {

                Address add1 = new Address();
                add1.setAId(rs.getString(1));
                add1.setAddressLine1(rs.getString(2));
                add1.setAddressLine2(rs.getString(3));
                add1.setCity(rs.getString(4));
                add1.setState(rs.getString(5));
                add1.setPincode(rs.getString(6));
                add1.setId(rs.getString(7));
                showList.add(add1);                
                System.out.println(showList);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if(rs != null) {
	        		rs.close();
	        	}
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }	
		return showList;
	}
	@Override
	public void deleteAddress(String removeId) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
		PreparedStatement stmt = null;
        try {
        	String sql = "delete from  address WHERE a_id = ?";
        	stmt = con.prepareStatement(sql);
            stmt.setString(1, removeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	        try {
	        	if (stmt != null) {
	                stmt.close();
	            }
	        }catch (SQLException sqlee) {
	            sqlee.printStackTrace();
	        }
	    }
	}
	@Override
	public void addNewAddress(User addNewAddress) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
        List<Address> count = addNewAddress.getAddress();
        PreparedStatement ps =null;
        System.out.println(count.size());
	    for(int i=0;i<count.size();i++)
	    {
	      try {
				String sql ="insert into address(a_id,addressLine1,addressLine2,city,state,pincode,id)values(?,?,?,?,?,?,?)";
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, null);
				ps.setString(2, count.get(i).getAddressLine1());
				ps.setString(3, count.get(i).getAddressLine2());
				ps.setString(4, count.get(i).getCity());
				ps.setString(5, count.get(i).getState());
				ps.setString(6, count.get(i).getPincode());
				ps.setString(7,	count.get(i).getId());
				ps.executeUpdate();
			}
        catch (SQLException e) 
    		{
                e.printStackTrace();
            }finally {
    	        try {
    	            if (con != null) {
    	                con.close();
    	            }
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	        try {
    	        	 if (ps != null) {
     	                ps.close();
     	            }
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	    }
    	}
	}
	@Override
	public void updateAddress(User user) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
        List<Address> count = user.getAddress();
        PreparedStatement ps = null;
        System.out.println(count.size());
        for (int i = 0; i < count.size(); i++) {
            String sql = "update address set  addressLine1=?,addressLine2=?,city=?,state=?,pincode=? where a_id=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, count.get(i).getAddressLine1());
				ps.setString(2, count.get(i).getAddressLine2());
				ps.setString(3, count.get(i).getCity());
				ps.setString(4, count.get(i).getState());
				ps.setString(5, count.get(i).getPincode());
				ps.setString(6, count.get(i).getAId());
                ps.executeUpdate();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }finally {
    	        try {
    	            if (con != null) {
    	                con.close();
    	            }
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	        try {
    	        	if (ps != null) {
    	                ps.close();
    	            }
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	    }
        }
	}
	@Override
	public User forgetPassword(User user) {
		// TODO Auto-generated method stub
		 	MyDb db = new MyDb();
			Connection con = db.genCon();	        
			ResultSet rs = null;
			PreparedStatement stmt = null;
	        User forgotpassword = new User();

	        try {
	            stmt = con.prepareStatement("select * from user where email= ? ");
	            stmt.setString(1, user.getEmail());
	            rs = stmt.executeQuery();
	            while (rs.next()) {
	            	
	                forgotpassword.setEmail(rs.getString(5));
	                forgotpassword.setPassword(rs.getString(6));
	            }

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
    	        try {
    	            if (con != null) {
    	                con.close();
    	            }
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	        try {
    	        	if(rs != null) {
    	        		rs.close();
    	        	}
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	        try {
    	        	if (stmt != null) {
    	                stmt.close();
    	            }
    	        } catch (SQLException sqlee) {
    	            sqlee.printStackTrace();
    	        }
    	    }
	        return forgotpassword;
	}
}