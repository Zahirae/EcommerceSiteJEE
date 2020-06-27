package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Beans.LigneCommande;

import com.mysql.jdbc.Connection;

public class LigneCommandeDao {
	 Connection con = (Connection) Connexion.getInstance();

	    public boolean add(LigneCommande a)
	    {
	        try
	        {
	            String req = "INSERT INTO `ecommerce`.`ligne_commande` (`idCommande`, `idArticle`, `qte`) "
	                    + "VALUES ('"+a.getIdCommande()+"', '"+a.getIdArticle()+"', '"+a.getQte()+"');";

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
	            String req = "DELETE FROM ligne_commande " + "WHERE idCommande = " + idCmd;

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

	    public Vector<LigneCommande> findAll()
	    {
	        String req = "SELECT* " + " FROM ligne_commande ";

	        Vector<LigneCommande> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<LigneCommande>();
	                }

	                LigneCommande e = new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3));
	                

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

	 public Vector<LigneCommande> findAll(int idCmd)
	    {
	        String req = "SELECT* " + " FROM ligne_commande WHERE idCommande = "+idCmd;

	        Vector<LigneCommande> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<LigneCommande>();
	                }

	                LigneCommande e = new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3));
	                

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

	 
	 
	     public Vector<LigneCommande> findById(int id)
	    {
	        String req = "SELECT* " + " FROM ligne_commande where idCommande="+id;

	        Vector<LigneCommande> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<LigneCommande>();
	                }

	                LigneCommande e = new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3));
	                

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
}
