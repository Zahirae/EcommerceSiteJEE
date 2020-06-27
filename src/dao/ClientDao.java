package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Beans.Client;

import com.mysql.jdbc.Connection;

public class ClientDao {
	 Connection con = (Connection) Connexion.getInstance();

	    public boolean add(Client a)
	    {
	        try
	        {
	            String req = "INSERT INTO `ecommerce`.`client` (`email`, `password`, `nom`, `prenom`)"
	                    + " VALUES ('" + a.getEmail() + "', '" + a.getPassword() + "', '" + a.getNom() + "', '" + a.getPrenom() + "');";

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public boolean remove(String login)
	    {
	        try
	        {
	            String req = "DELETE FROM client " + "WHERE email = '"+login+"' " ; 
	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public boolean update(Client a)
	    {
	        try
	        {
	            String req = "UPDATE `ecommerce`.`client` "
	                    + "SET `password`='" + a.getPassword() + "', "
	                    + "`nom`='" + a.getNom() + "', "
	                    + "`prenom`='" + a.getPrenom() + "' "
	                    + "WHERE `email`='" + a.getEmail() + "';";

	            System.out.println(req);

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public Client findByAuthentification(String log, String pass)
	    {
	        String req = "SELECT* " + " FROM client " + " WHERE email = '" + log + "' AND password = '" + pass + "';";

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            Client e = null;

	            if (rs.next())
	            {
	                //public Client(String login, String mdp, String nom, String prenom 

	                e = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

	            }
	            return e;

	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }

	        return null;
	    }

	    public Vector<Client> findAll()
	    {
	        String req = "SELECT* " + " FROM client ";

	        Vector<Client> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Client>();
	                }

	                Client e = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));

	                vect.add(e);
	            }

	            return vect;
	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }

	    public boolean bloquer(String login)
	    {
	        try
	        {
	            String req = "UPDATE client SET "
	                    + "etat=0"
	                    + " WHERE email='" + login + "';";

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public boolean modifier(Client a)
	    {
	        try
	        {
	            String req = "UPDATE `ecommerce`.`client` SET "
	                    + "`password`='" + a.getPassword() + "', "
	                    + "`nom`='" + a.getNom() + "', "
	                    + "`prenom`='" + a.getPrenom() + "', "
	                    + "`etat`=" + a.getEtat() + "  "
	                    + "WHERE `email`='" + a.getEmail() + "';";

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    
	    
	        public Client findByLogin(String log)
	    {
	        String req = "SELECT* " + " FROM client " + " WHERE email = '" + log + "';";

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            Client e = null;

	            if (rs.next())
	            {
	                //public Client(String login, String mdp, String nom, String prenom, Date dtNaissance)
	                
	                e = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	                
	            }
	            return e;

	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }

	        return null;
	    }
}
