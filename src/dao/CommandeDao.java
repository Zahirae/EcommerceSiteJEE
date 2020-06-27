package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Beans.Client;
import Beans.Commande;

import com.mysql.jdbc.Connection;

public class CommandeDao {
	 Connection con = (Connection) Connexion.getInstance();

	    public boolean add(Commande a)
	    {
	        try
	        {
	            String req = "INSERT INTO `ecommerce`.`commande` (`login`, `idArticle`, `prixtotale`) "
	                    + "VALUES ('"+a.getLogin()+"','"+a.getIdArticle()+"', '"+a.getPrixTotale()+"');";

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

	    public boolean remove(int idCmd)
	    {
	        try
	        {
	            String req = "DELETE FROM commande " + "WHERE idcommande = " + idCmd;

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

	    public boolean validerCommande(int idCommande)
	    {
	        try
	        {
	            String req = "UPDATE `ecommerce`.`commande` SET "
	                    + "`etat`='1' "
	                    + "WHERE `idcommande`='"+idCommande+"';";

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

	     public boolean refuserCommande(int idCommande)
	    {
	        try
	        {
	            String req = "UPDATE `ecommerce`.`commande` SET "
	                    + "`etat`='2' "
	                    + "WHERE `idcommande`='"+idCommande+"';";

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

	     
	    public Vector<Commande> findByLogin(String login)
	    {
	        String req = "SELECT* " + " FROM commande WHERE login = '" +login+"';";

	        Vector<Commande> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Commande>();
	                }

	                Commande e = new Commande(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDate(4), rs.getDouble(5), rs.getInt(6));
	                

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
	    
	    public Commande findById(int id)
	    {
	        String req = "SELECT* " + " FROM commande WHERE idCommande = '" +id+"';";

	        Commande c = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	 	            if (rs.next())
	 	            {

	 	                c = new Commande(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDouble(5),rs.getInt(1));

	 	            }

	            return c;
	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }
	    
	    public Vector<Commande> findAll()
	    {
	        String req = "SELECT* " + " FROM commande ";

	        Vector<Commande> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Commande>();
	                }

	                Commande e = new Commande(rs.getInt(1), rs.getString(2),rs.getInt(3),  rs.getDate(4), rs.getDouble(5), rs.getInt(6));
	                

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


	    
	    public int getLastID()
	    {
	        String req = "SELECT max(idcommande) FROM commande ";

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            if (rs.next())
	            {
	                return rs.getInt(1);
	            }

	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return -1;
	    }

	    
	    public Vector<Commande> findEnAttente()
	    {
	        String req = "SELECT* " + " FROM commande where etat=0";

	        Vector<Commande> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Commande>();
	                }

	                Commande e = new Commande(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDate(4), rs.getDouble(5), rs.getInt(6));
	                

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
	    
	    public int calculQte(String login, int idArt)
	    {
	        String req = "SELECT COUNT(*) " + " FROM commande where login = '" +login + "' AND idArticle = '" + idArt + "';";


	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            if (rs.next())
	            {
	                return rs.getInt(1);
	            }

	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return -1;
	    }
}
